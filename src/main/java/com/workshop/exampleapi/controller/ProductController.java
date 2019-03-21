package com.workshop.exampleapi.controller;

import com.workshop.exampleapi.delegate.ProductDelegate;
import com.workshop.exampleapi.exceptions.ProductBadRequestException;
import com.workshop.exampleapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ProductController {

    Logger logger = Logger.getLogger(ProductController.class.getName());

    @Autowired
    ProductDelegate service;

    @GetMapping(value="/products")
    public List<Product> getProducts() {
        logger.log(Level.INFO, "get list of products");
        return service.getProducts();
    }

    @GetMapping(value = "/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @PostMapping(value="/products")
    public Product addProduct(@RequestBody @Valid Product product) {
        return service.addNewProduct(product);
    }

    @PutMapping(value = "/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newData) {
        try {
            if(id.equals(newData.getId())) {
                return service.updateProduct(id, newData);
            }
            else {
                throw new ProductBadRequestException();
            }
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            throw exception;
        }
    }

    @DeleteMapping(value = "/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
