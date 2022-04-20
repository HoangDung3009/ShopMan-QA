package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffDAOTest {
    StaffDAO staffDAO = new StaffDAO();
    @Test
    void checkLogin() {
        String username = "";
        String password = "";
        Staff staff = staffDAO.checkLogin(username, password);
        assertNotNull(staff);
        assertEquals(2, staff.getId());
    }

    @Test
    void checkLogin1() {
        String username = "admin123";
        String password = "admin123";
        Staff staff = staffDAO.checkLogin(username, password);
        assertNotNull(staff);
        assertEquals(1, staff.getId());
        assertEquals("admin123", staff.getUsername());
        assertEquals("admin123", staff.getPassword());
    }
}