package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.ProductStat;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatDAOTest {

    ProductStatDAO productStatDAO = new ProductStatDAO();
    @Test
    void getProductStat() {
        String startDate = "asdasdasd";
        String endDate = "asdasdasd";
        List<ProductStat> productStatList = productStatDAO.getProductStat(startDate,endDate);
        assertEquals(0, productStatList.get(0).getRevenue());
    }

    @Test
    void getProductStat1() {
        String startDate = "2022-01-01";
        String endDate = "2022-05-01";
        List<ProductStat> productStatList = productStatDAO.getProductStat(startDate,endDate);
        assertEquals(3800000, productStatList.get(0).getRevenue());
    }

    @Test
    void getProductStat2() {
        String startDate = "2022-01-01";
        List<ProductStat> productStatList = productStatDAO.getProductStat1(startDate);
        assertEquals(3800000, productStatList.get(0).getRevenue());
    }

    @Test
    void getProductStat3() {
        String startDate = "2022-05-01";
        List<ProductStat> productStatList = productStatDAO.getProductStat1(startDate);
        assertEquals(3800000, productStatList.get(0).getRevenue());
    }

    @Test
    void getProductStat4() {
        String endDate = "2022-05-01";
        List<ProductStat> productStatList = productStatDAO.getProductStat2(endDate);
        assertEquals(3800000, productStatList.get(0).getRevenue());
    }

    @Test
    void getProductStat5() {
        String endDate = "2022-05-01";
        List<ProductStat> productStatList = productStatDAO.getProductStat2(endDate);
        assertEquals(3800000, productStatList.get(0).getRevenue());
    }

}