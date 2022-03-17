package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String cusName;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String creditCard;
    private String creditCardType;
    private String cardExpMonth;
    private String cardExpYear;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCardExpMonth() {
        return cardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public String getCardExpYear() {
        return cardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public Customer(int id, String cusName, String phone, String email, String username, String password, String creditCard, String creditCardType, String cardExpMonth, String cardExpYear) {
        this.id = id;
        this.cusName = cusName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.creditCard = creditCard;
        this.creditCardType = creditCardType;
        this.cardExpMonth = cardExpMonth;
        this.cardExpYear = cardExpYear;
    }
}
