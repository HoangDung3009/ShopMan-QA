package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Payment implements Serializable {
    private int id;
    private String method;
    private String allowed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }

    public Payment(int id, String method, String allowed) {
        this.id = id;
        this.method = method;
        this.allowed = allowed;
    }

    public Payment() {
    }
}
