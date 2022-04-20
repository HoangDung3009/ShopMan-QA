package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest {
    CategoryDAO categoryDAO = new CategoryDAO();

    @Test
    void getCategoryById() {
        int id = 0;
        Category category = categoryDAO.getCategoryById(id);
        assertEquals(0, category.getId());
    }

    @Test
    void getCategoryById1() {
        int id = 2;
        Category category = categoryDAO.getCategoryById(id);
        assertEquals(2, category.getId());
        assertEquals("Jacket", category.getCatName());
    }

    @Test
    void getCategoryById3() {
        int id = 100;
        Category category = categoryDAO.getCategoryById(id);
        assertEquals(0, category.getId());
    }
}