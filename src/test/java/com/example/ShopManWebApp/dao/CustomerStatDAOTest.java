package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.CustomerStat;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStatDAOTest {
    CustomerStatDAO customerStatDAO = new CustomerStatDAO();
    @Test
    void getCustomerStat() {
        String startDate = "2000-01-01";
        String endDate = "2022-05-01";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat(startDate, endDate);
        assertEquals(3700000, customerStatList.get(0).getRevenue());
    }

    @Test
    void getCustomerStat1() {
        String startDate = "";
        String endDate = "";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat(startDate, endDate);
        assertEquals(0, customerStatList.get(0).getRevenue());
    }

    @Test
    void getCustomerStat2() {
        String startDate = "2020-01-01";
        String endDate = "2023-01-01";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat(startDate, endDate);
        assertEquals(3700000, customerStatList.get(0).getRevenue());

    }

    @Test
    void getCustomerStat3() {
        String startDate = "4458654822";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat1(startDate);
        assertEquals(0, customerStatList.get(1).getRevenue());
    }

    @Test
    void getCustomerStat4() {
        String startDate = "2022-04-01";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat1(startDate);
        assertEquals(0, customerStatList.get(0).getRevenue());
    }

    @Test
    void getCustomerStat5() {
        String endDate = "2021-01-01";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat2(endDate);
        assertEquals(0, customerStatList.get(0).getRevenue());
    }

    @Test
    void getCustomerStat6() {
        String endDate = "2022-04-01";
        List<CustomerStat> customerStatList = customerStatDAO.getCustomerStat2(endDate);
        assertEquals(3700000, customerStatList.get(0).getRevenue());
    }
}