package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Shipper implements Serializable {
    private int id;
    private String shipperName;
    private String shipperCompany;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperCompany() {
        return shipperCompany;
    }

    public void setShipperCompany(String shipperCompany) {
        this.shipperCompany = shipperCompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Shipper(int id, String shipperName, String shipperCompany, String phone) {
        this.id = id;
        this.shipperName = shipperName;
        this.shipperCompany = shipperCompany;
        this.phone = phone;
    }

    public Shipper() {
    }
}
