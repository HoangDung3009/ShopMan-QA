package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private Shipper shipper;
    private Customer customer;
    private Staff staff;
    private ShippingAddress shippingAddress;
    private Payment payment;
    private String orderDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Order(int id, Shipper shipper, Customer customer, Staff staff, ShippingAddress shippingAddress, Payment payment, String orderDate) {
        this.id = id;
        this.shipper = shipper;
        this.customer = customer;
        this.staff = staff;
        this.shippingAddress = shippingAddress;
        this.payment = payment;
        this.orderDate = orderDate;
    }

    public Order() {
    }
}
