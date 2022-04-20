package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;
import com.example.ShopManWebApp.model.ShippingAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressDAOTest {

    ShippingAddressDAO shippingAddressDAO = new ShippingAddressDAO();
    @Test
    void addShipAddress() {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddressDAO.addShipAddress(shippingAddress);
        assertEquals(22, shippingAddress.getId());
    }

    @Test
    void addShipAddress1() {
        ShippingAddress shippingAddress = new ShippingAddress();
        Customer customer = new Customer();
        customer.setId(1);
        shippingAddress.setCity("Thai Binh");
        shippingAddress.setDistrict("Thu Thiem");
        shippingAddress.setRoad("124 Tran Hung Dao");
        shippingAddress.setCustomer(customer);
        shippingAddressDAO.addShipAddress(shippingAddress);
        assertEquals(22, shippingAddress.getId());
    }

    @Test
    void checkAddress() {
        ShippingAddress shippingAddress = new ShippingAddress();
        Customer customer = new Customer();
        customer.setId(2);
        String city = "Ha Noi";
        String state = "Ha Noi";
        String road = "Ha Noi";
        shippingAddress.setCity(city);
        shippingAddress.setRoad(road);
        shippingAddress.setDistrict(state);
        shippingAddress.setCustomer(customer);
        ShippingAddress checkCity = shippingAddressDAO.checkAddress(shippingAddress);


        assertNotNull(checkCity);
    }

    @Test
    void checkAddress1() {
        ShippingAddress shippingAddress = new ShippingAddress();
        Customer customer = new Customer();
        customer.setId(1);
        String city = "Ha Noi";
        String state = "Ha Dong";
        String road = "CT2A XA La";
        shippingAddress.setCity(city);
        shippingAddress.setRoad(road);
        shippingAddress.setDistrict(state);
        shippingAddress.setCustomer(customer);
        ShippingAddress checkCity = shippingAddressDAO.checkAddress(shippingAddress);


        assertNotNull(checkCity);
        assertEquals(city, checkCity.getCity());
        assertEquals(state, checkCity.getDistrict());
        assertEquals(road, checkCity.getRoad());
    }
}