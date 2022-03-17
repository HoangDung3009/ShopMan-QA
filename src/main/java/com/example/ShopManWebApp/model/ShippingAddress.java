package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class ShippingAddress implements Serializable {
    private int id;
    private String road;
    private String district;
    private String city;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingAddress(int id, String road, String district, String city, Customer customer) {
        this.id = id;
        this.road = road;
        this.district = district;
        this.city = city;
        this.customer = customer;
    }

    public ShippingAddress() {
    }
}
