package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierDAOTest {

    SupplierDAO supplierDAO = new SupplierDAO();
    @Test
    void getSupplierById() {
        int id = 0;
        Supplier supplier = supplierDAO.getSupplierById(id);
        assertNotNull(supplier);
        assertEquals("Canifa Bac Ninh", supplier.getSupName());
    }

    @Test
    void getSupplierById1() {
        int id = 2;
        Supplier supplier = supplierDAO.getSupplierById(id);
        assertNotNull(supplier);
        assertEquals("Canifa Bac Ninh", supplier.getSupName());
    }

}