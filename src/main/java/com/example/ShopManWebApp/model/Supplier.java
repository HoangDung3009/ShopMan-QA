package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Supplier implements Serializable {
    private int id;
    private String supName;
    private String address;
    private String city;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Supplier(int id, String supName, String address, String city, String phone, String email) {
        this.id = id;
        this.supName = supName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public Supplier() {
    }
}
