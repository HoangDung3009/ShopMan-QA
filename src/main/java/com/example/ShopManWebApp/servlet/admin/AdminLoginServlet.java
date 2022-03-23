package com.example.ShopManWebApp.servlet.admin;

import com.example.ShopManWebApp.dao.StaffDAO;
import com.example.ShopManWebApp.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLogin", value = "/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    private StaffDAO staffDAO = new StaffDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Staff staff = staffDAO.checkLogin(username, password);

        HttpSession session = request.getSession();
        if(staff == null){
            session.setAttribute("message", "Wrong username or password");
            response.sendRedirect("views/admin/admin-login.jsp");
            return;
        }
        else {
            session.setAttribute("current-admin", staff);
            response.sendRedirect("views/admin/admin-home.jsp");
        }
    }
}
