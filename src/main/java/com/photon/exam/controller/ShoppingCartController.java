package com.photon.exam.controller;

import com.photon.exam.exception.ShoppingCartException;
import com.photon.exam.model.ErrorResponse;
import com.photon.exam.model.Product;
import com.photon.exam.model.Response;
import com.photon.exam.model.SuccessResponse;
import com.photon.exam.service.ShoppingCartService;
import com.photon.exam.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private TaxService taxService;

    /**
     * List all products in the shopping cart
     * @return
     */
    @GetMapping("/get")
    public Response getCart() {

        Collection<Product> data = cartService.getProducts();
        Response response = new SuccessResponse("Product listing");
        response.setData(data);
        return response;
    }

    /**
     * If the product to add is in the cart, then update the quantity
     * @param product (all attributes are required)
     * @return
     */
    @PostMapping("/add")
    public Response addProduct(@RequestBody Product product) {
        Double taxes = taxService.getTaxes(product.getType(), product.getPrice());
        if (taxes == null) {
            return new ErrorResponse("Type is required");
        }
        product.setTaxes(taxes);
        Collection<Product> data = cartService.add(product);

        Response response = new SuccessResponse("Product added");
        response.setData(data);
        return response;
    }

    /**
     * Edit replace the quantity
     * @param product (id, and quantity are required)
     * @return
     */
    @PostMapping("/edit")
    public Response editProduct(@RequestBody Product product) {

        Collection<Product> data = null;
        try {
            data = cartService.edit(product);
        } catch (ShoppingCartException e) {
            return new ErrorResponse(e.getMessage());
        }

        Response response = new SuccessResponse("Product edited");
        response.setData(data);
        return response;
    }

    /**
     * Delete the product in the cart
     * @param product
     * @return
     */
    @DeleteMapping("/remove")
    public Response removeProduct(@RequestBody Product product) {
        try {
            cartService.remove(product.getId());
        } catch (ShoppingCartException e) {
            return new ErrorResponse(e.getMessage());
        }
        return new SuccessResponse("Product removed");
    }

}

