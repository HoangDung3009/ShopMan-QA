package com.example.ShopManWebApp.servlet.admin;

import com.example.ShopManWebApp.dao.ProductStatDAO;
import com.example.ShopManWebApp.model.ProductStat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductStat", value = "/ProductStat")
public class ProductStatServlet extends HttpServlet {
    private List<ProductStat> listStat = new ArrayList<>();
    private ProductStatDAO productStatDAO = new ProductStatDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");

        System.out.println(startDate);
        System.out.println(endDate);

        if(startDate.equals("") && endDate.equals("")){
            listStat = productStatDAO.getAllProductStat();
        } else if (endDate.equals("")){
            listStat = productStatDAO.getProductStat1(startDate);
        } else if (startDate.equals("")){
            listStat = productStatDAO.getProductStat2(endDate);
        } else {
            listStat = productStatDAO.getProductStat(startDate, endDate);
        }

        HttpSession session = request.getSession();
        session.setAttribute("product-stat", listStat);
        response.sendRedirect("views/admin/product-statistic.jsp");
    }
}
