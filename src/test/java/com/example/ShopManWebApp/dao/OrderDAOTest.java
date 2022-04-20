package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    OrderDAO orderDAO = new OrderDAO();

    @Test
    void getOrderByCustomer() {
        int id = 0;
        List<Order> orderDAOList = orderDAO.getOrderByCustomer(id);
        assertEquals(0, orderDAOList.size());
    }

    @Test
    void getOrderByCustomer1() {
        int id = 2;
        List<Order> orderDAOList = orderDAO.getOrderByCustomer(id);
        assertEquals(2, orderDAOList.size());
    }

    @Test
    void getOrderByCustomer3() {
        int id = 12;
        List<Order> orderDAOList = orderDAO.getOrderByCustomer(id);
        assertEquals(0, orderDAOList.size());
    }

    @Test
    void addOrder() {
        Order order = new Order();
        orderDAO.addOrder(order);
        assertEquals(31, order.getId());
    }
}