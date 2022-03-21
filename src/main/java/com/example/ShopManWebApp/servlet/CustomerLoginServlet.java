package com.example.ShopManWebApp.servlet;

import com.example.ShopManWebApp.dao.CustomerDAO;
import com.example.ShopManWebApp.model.Customer;
import com.example.ShopManWebApp.model.OrderDetail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerLogin", value = "/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
    private CustomerDAO customerDAO = new CustomerDAO();
    private List<OrderDetail> cart = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/customer-login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Customer customer = customerDAO.checkLogin(username,password);

        HttpSession httpSession = request.getSession();
        if(customer == null){
            httpSession.setAttribute("message","*Invalid Details !! Try with another one*");
            response.sendRedirect("views/customer-login.jsp");
            return;
        }else {
            httpSession.setAttribute("current-customer", customer);
            httpSession.setAttribute("cart", cart);
            response.sendRedirect("views/product-list.jsp");
        }
    }
}
