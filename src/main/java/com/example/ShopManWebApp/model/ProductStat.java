package com.example.ShopManWebApp.model;

public class ProductStat extends Product{
    private double revenue;
    private int quantity;


    public ProductStat() {
        super();
    }

    public ProductStat(int id, String prodName, double price, String color, String size, String picture, String status, double discount, String description, Supplier supplier, Category category, int unitInStock, int unitSold, double revenue, int quantity) {
        super(id, prodName, price, color, size, picture, status, discount, description, supplier, category, unitInStock, unitSold);
        this.revenue = revenue;
        this.quantity = quantity;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
