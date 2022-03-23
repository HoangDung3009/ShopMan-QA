package com.example.ShopManWebApp.model;

public class CustomerStat extends Customer{
    private double revenue;
    private int order_time;

    public CustomerStat() {
        super();
    }

    public CustomerStat(double revenue, int order_time) {
        this.revenue = revenue;
        this.order_time = order_time;

    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getOrder_time() {
        return order_time;
    }

    public void setOrder_time(int order_time) {
        this.order_time = order_time;
    }
}
