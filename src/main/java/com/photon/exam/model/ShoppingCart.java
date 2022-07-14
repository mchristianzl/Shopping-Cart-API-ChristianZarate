package com.photon.exam.model;

import java.util.*;

public class ShoppingCart {

    private Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }
}
