package com.example.ShopManWebApp.servlet;

import com.example.ShopManWebApp.dao.ProductDAO;
import com.example.ShopManWebApp.model.OrderDetail;
import com.example.ShopManWebApp.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cart", value = "/Cart")
public class CartServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private List<OrderDetail> cart = new ArrayList<>();

    public CartServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String command = request.getParameter("command");
            int id = Integer.parseInt(request.getParameter("product_id"));

            if (command.equals("QuickAddCart")){
                Product p = productDAO.getProductById(id);
                addToCart(p);

                HttpSession session = request.getSession();
                System.out.println(cart.size());
                session.setAttribute("cart", cart);
                response.sendRedirect("views/product-list.jsp");
            }
            else if (command.equals("addCart")){
                Product p = productDAO.getProductById(id);
                addToCart(p);

                HttpSession session = request.getSession();
                System.out.println(cart.size());
                session.setAttribute("cart", cart);
                response.sendRedirect("views/cart.jsp");
            }
            else if (command.equals("setCart")){
                Product p = productDAO.getProductById(id);
                setCart(p, Integer.parseInt(request.getParameter("quantity")));

                HttpSession session = request.getSession();
                System.out.println(cart.size());
                session.setAttribute("cart", cart);
                response.sendRedirect("views/product-detail.jsp?product_id=" + id);
            }
            else if (command.equals("deleteFromCart")){
                Product p = productDAO.getProductById(id);
                deleteFromCart(p);

                HttpSession session = request.getSession();
                System.out.println(cart.size());
                session.setAttribute("cart", cart);
                response.sendRedirect("views/cart.jsp");
            }

            else if (command.equals("removeFromCart")){
                Product p = productDAO.getProductById(id);
                removeFromCart(p);

                HttpSession session = request.getSession();
                session.setAttribute("cart", cart);
                response.sendRedirect("views/cart.jsp");
            }
            else if (command.equals("removeAll")){
                removeAll();

                HttpSession session = request.getSession();
                session.setAttribute("cart", cart);
                response.sendRedirect("views/cart.jsp");
            }
    }
//    Tao gio hang
    private String setCart(Product p, int s){
        for (OrderDetail item : cart){
            if (item.getProduct().getId() == p.getId()){
                item.setQuantity(item.getQuantity() + s);
                return "cart";
            }
        }

        OrderDetail o =  new OrderDetail();
        o.setProduct(p);
        o.setQuantity(s);
        cart.add(o);
        return "cart";
    }

//Them vao gio hang
    private String addToCart(Product p){
        for (OrderDetail item : cart){
            if (item.getProduct().getId() == p.getId()){
                item.setQuantity(item.getQuantity() + 1);
                return "cart";
            }
        }

        OrderDetail o =  new OrderDetail();
        o.setProduct(p);
        o.setQuantity(1);
        cart.add(o);
        return "cart";
    }
//tru so luong san pham di 1
    private String deleteFromCart(Product p){
        for (OrderDetail item : cart){
            if (item.getProduct().getId() == p.getId() && item.getQuantity() > 1){
                item.setQuantity(item.getQuantity() - 1);
                return "cart";
            }
        }
        return "cart";
    }
//Xoa san pham khoi gio hang
    private String removeFromCart(Product p){
        for (OrderDetail item : cart){
            if (item.getProduct().getId() == p.getId()){
                cart.remove(item);
                return "cart";
            }
        }
        return "cart";
    }
    //Xoa het san pham khoi gio hang
    private String removeAll(){
        cart.clear();
        return "cart";
    }
}
