package com.photon.exam.service;

import com.photon.exam.exception.ShoppingCartException;
import com.photon.exam.model.Product;
import com.photon.exam.model.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class ShoppingCartServiceImp implements ShoppingCartService {

    private ShoppingCart data = new ShoppingCart();

    @Override
    public Collection<Product> getProducts() {
        return data.getProducts().values();
    }

    @Override
    public Collection<Product> add(Product product) {
        System.out.println(product);
        Product existing = data.getProducts().get(product.getId());
        if (existing != null) {
            product.setQuantity(product.getQuantity() + existing.getQuantity());
            System.out.println("Quantity now =  " + product.getQuantity());
        }
        System.out.println(product);
        data.getProducts().put(product.getId(), product);
        return data.getProducts().values();
    }

    @Override
    public Collection<Product> edit(Product product) throws ShoppingCartException {
        Product existing = data.getProducts().get(product.getId());
        if (existing == null) {
            throw new ShoppingCartException("Product not found in the cart");
        }

        existing.setQuantity(product.getQuantity());

        data.getProducts().put(product.getId(), existing);
        return data.getProducts().values();
    }

    @Override
    public Collection<Product> remove(int id) throws ShoppingCartException {

        if (!data.getProducts().containsKey(id)) {
            throw new ShoppingCartException("Product not found in the cart");
        }

        data.getProducts().remove(id);
        return data.getProducts().values();
    }
}
