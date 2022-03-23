package com.example.ShopManWebApp.servlet.admin;

import com.example.ShopManWebApp.dao.CustomerStatDAO;
import com.example.ShopManWebApp.model.CustomerStat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerStat", value = "/CustomerStat")
public class CustomerStatServlet extends HttpServlet {
    private List<CustomerStat> listStat = new ArrayList<>();
    private CustomerStatDAO customerStatDAO = new CustomerStatDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startDate1 = request.getParameter("start-date");
        String endDate1 = request.getParameter("end-date");

        System.out.println(startDate1);
        System.out.println(endDate1);

        if(startDate1.equals("") && endDate1.equals("")){
            listStat = customerStatDAO.getAllCustomerStat();
        } else if (endDate1.equals("")){
            listStat = customerStatDAO.getCustomerStat1(startDate1);
        } else if (startDate1.equals("")){
            listStat = customerStatDAO.getCustomerStat2(endDate1);
        } else {
            listStat = customerStatDAO.getCustomerStat(startDate1, endDate1);
        }

        HttpSession session = request.getSession();
        session.setAttribute("customer-stat", listStat);
        response.sendRedirect("views/admin/customer-statistic.jsp");
    }
}
