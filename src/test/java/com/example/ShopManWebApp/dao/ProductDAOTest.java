package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {
    ProductDAO productDAO = new ProductDAO();

    @Test
    void searchProduct() {
        String key = "";
        List<Product> productList = productDAO.searchProduct(key);
        assertEquals(8, productList.size());
    }

    @Test
    void searchProduct1() {
        String key = "dlkfgjldkfg";
        List<Product> productList = productDAO.searchProduct(key);
        assertEquals(0, productList.size());
    }

    @Test
    void getProductById() {
        int id = 100;
        Product product = productDAO.getProductById(id);
        assertEquals(100, product.getId());
    }

    @Test
    void getProductById1() {
        int id = 2;
        Product product = productDAO.getProductById(id);
        assertEquals(2, product.getId());
    }

    @Test
    void getProductById2() {
        int id = 0;
        Product product = productDAO.getProductById(id);
        assertEquals(0, product.getId());
    }
}