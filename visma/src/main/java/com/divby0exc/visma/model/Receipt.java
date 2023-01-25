package com.divby0exc.visma.model;

import java.sql.Date;
import java.time.LocalDate;

public class Receipt {
    private String title;
    private String description;
    private String category;
    private double price;
    private Date date;

    public Receipt(){}

    public Receipt(String title, String description, String category, double price) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.date = Date.valueOf(LocalDate.now());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
