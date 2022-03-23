package com.example.ShopManWebApp.servlet;

import com.example.ShopManWebApp.dao.*;
import com.example.ShopManWebApp.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CheckOut", value = "/CheckOut")
public class CheckOutServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private ShippingAddressDAO shippingAddressDAO = new ShippingAddressDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    private List<OrderDetail> cart = new ArrayList<>();
    private Customer customer = new Customer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customer = (Customer) request.getSession().getAttribute("current-customer");
        cart = (List<OrderDetail>) request.getSession().getAttribute("cart");

//Tao mot order
        Order order = new Order();
        ShippingAddress address = new ShippingAddress();
        Payment payment = new Payment();
        Shipper shipper = new Shipper();


//        Them dia chi
        address.setCity(request.getParameter("city"));
        address.setDistrict(request.getParameter("district"));
        address.setRoad(request.getParameter("road"));
        address.setCustomer(customer);
        ShippingAddress ad1 = shippingAddressDAO.checkAddress(address);
        if (ad1 == null){
            shippingAddressDAO.addShipAddress(address);
        }

//        Check id dia chi
        System.out.println(address.getId());

        shipper.setId(Integer.parseInt(request.getParameter("shipper")));
        payment.setId(Integer.parseInt(request.getParameter("payment")));

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String order_date = dateFormat.format(date);

        order.setOrderDate(order_date);
        order.setShipper(shipper);
        order.setCustomer(customer);
        order.setPayment(payment);
        order.setShippingAddress(address);
        order.setReceive_date("");
        order.setStatus("Processing...");
//luu order vao csdl
        orderDAO.addOrder(order);

        if (cart != null){
            for (OrderDetail i : cart){
                Product p = i.getProduct();
                p.setUnitInStock(p.getUnitInStock() - i.getQuantity());
                p.setUnitSold(p.getUnitSold() + i.getQuantity());
                i.setOrder(order);
//                luu chi tiet order vao csdl
                orderDetailDAO.addOrderDetail(i);
//                productDAO.updateQuantity(p);
            }
        }

        cart.clear();

        HttpSession session = request.getSession();
        session.setAttribute("cart", cart);
        response.sendRedirect("views/product-list.jsp");
    }
}
