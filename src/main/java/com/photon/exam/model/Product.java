package com.photon.exam.model;

import com.photon.exam.util.Types;
import com.sun.istack.NotNull;

import javax.persistence.Basic;

public class Product {

    private int id;

    @NotNull
    private String title;

    private Double price;

    private int quantity;


    private double taxes;

    @Basic(optional = false)
    private Types type;

    public Product() {

    }
    public Product(int id, String title, Double price, int availables) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = availables;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", taxes=" + taxes +
                ", type=" + type +
                '}';
    }
}

