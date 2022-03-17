package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String prodName;
    private double price;
    private String color;
    private String size;
    private String picture;
    private String status;
    private double discount;
    private String description;
    private Supplier supplier;
    private Category category;

    public Product() {
    }

    public Product(int id, String prodName, double price, String color, String size, String picture, String status, double discount, String description, Supplier supplier, Category category) {
        this.id = id;
        this.prodName = prodName;
        this.price = price;
        this.color = color;
        this.size = size;
        this.picture = picture;
        this.status = status;
        this.discount = discount;
        this.description = description;
        this.supplier = supplier;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
