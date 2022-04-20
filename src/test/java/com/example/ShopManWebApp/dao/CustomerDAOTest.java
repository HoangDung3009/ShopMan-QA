package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {
    CustomerDAO customerDAO = new CustomerDAO();

    @Test
    void checkLogin() {
        String username = "hoangdung3009";
        String password = "dung3009";
        Customer customer = customerDAO.checkLogin(username,password);
        assertNotNull(customer);
        assertEquals("hoangdung3009", customer.getUsername());
        assertEquals("dung3009", customer.getPassword());
    }

    @Test
    void checkLogin2() {
        String username = "";
        String password = "";
        Customer customer = customerDAO.checkLogin(username,password);
        assertNotNull(customer);
        assertEquals("hoangdung3009", customer.getUsername());
        assertEquals("dung3009", customer.getPassword());
    }

    @Test
    void getCustomerById() {
        int i = 0;
        Customer customer = customerDAO.getCustomerById(i);
        assertNotNull(customer);
        assertEquals("hoangdung3009", customer.getUsername());
    }

    @Test
    void getCustomerById1() {
        int i = 1;
        Customer customer = customerDAO.getCustomerById(i);
        assertNotNull(customer);
        assertEquals("hoangdung3009", customer.getUsername());
    }

    @Test
    void getCustomerById2() {
        int i = 100;
        Customer customer = customerDAO.getCustomerById(i);
        assertNotNull(customer);
        assertEquals("hoangdung3009", customer.getUsername());
    }
}