package com.example.springinputdata.controller;

import com.example.springinputdata.model.Product;
import com.example.springinputdata.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SingletonDemoController {

    private ProductService productService;

    public SingletonDemoController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }
}
