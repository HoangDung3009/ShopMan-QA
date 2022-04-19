package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    @Test
    void checkLogin() {
        String username = "hoangdung3009";
        String password = "dung3009";
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.checkLogin(username,password);
        assertEquals("hoangdung3009", customer.getUsername());
        assertEquals("dung3009", customer.getPassword());
    }

    @Test
    void getCustomerById() {
    }
}