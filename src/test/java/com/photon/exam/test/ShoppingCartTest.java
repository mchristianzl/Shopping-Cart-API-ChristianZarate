package com.photon.exam.test;

import com.photon.exam.Application;
import com.photon.exam.controller.ShoppingCartController;
import com.photon.exam.model.Product;
import com.photon.exam.model.Response;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = { Application.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private int port = 8080;

    @Autowired
    private ShoppingCartController cartController;

    @Test
    public void contextLoads() {
        Assertions
                .assertThat(cartController)
                .isNotNull();
    }

    @Test
    public void checkingTheResponse() {
        ResponseEntity<Response> responseEntity =
                restTemplate.exchange("http://localhost:8080/cart/get",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        Response response = responseEntity.getBody();
        response.getData();
        Assertions
                .assertThat(response.getCode())
                .isGreaterThan(0);
    }

    @Test
    public void editingProducts() {
        //RequestEntity<Product> request = new RequestEntity<>();
        Product product = new Product();
        ResponseEntity<Response> responseEntity =
                restTemplate.exchange("http://localhost:8080/cart/edit",
                        HttpMethod.POST, null, new ParameterizedTypeReference<>() {
                        });
        Response response = responseEntity.getBody();
        response.getData();
        Assertions
                .assertThat(response.getCode())
                .isGreaterThan(0);
    }


    @Test
    public void test1() {

    }

}
