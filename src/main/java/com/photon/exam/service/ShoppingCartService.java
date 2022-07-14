package com.photon.exam.service;

import com.photon.exam.exception.ShoppingCartException;
import com.photon.exam.model.Product;
import com.photon.exam.model.ShoppingCart;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Validated
public interface ShoppingCartService {

    Collection<Product> getProducts();

    Collection<Product> add(Product product);
    Collection<Product> edit(Product product) throws ShoppingCartException;

    public Collection<Product> remove(int id) throws ShoppingCartException;
}
