package com.example.ShopManWebApp.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String catName;
    private String catDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public Category(int id, String catName, String catDescription) {
        this.id = id;
        this.catName = catName;
        this.catDescription = catDescription;
    }

    public Category() {
    }
}
