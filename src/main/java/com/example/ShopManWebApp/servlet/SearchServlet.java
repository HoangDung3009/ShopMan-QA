package com.example.ShopManWebApp.servlet;

import com.example.ShopManWebApp.dao.ProductDAO;
import com.example.ShopManWebApp.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class SearchServlet extends HttpServlet {
    ProductDAO produdctDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("search-key");
        List<Product> searchProducts;

        if(keyword.equals("")){
            searchProducts = produdctDAO.getAllProduct();
        }
        else {
            searchProducts = produdctDAO.searchProduct(keyword);
        }

        request.setAttribute("search-result", searchProducts);
        request.getRequestDispatcher("views/search-list.jsp").forward(request,response);
    }
}
