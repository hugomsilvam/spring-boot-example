package com.workshop.exampleapi.delegate;

import com.workshop.exampleapi.exceptions.ProductBadRequestException;
import com.workshop.exampleapi.exceptions.ProductNotFoundException;
import com.workshop.exampleapi.models.Product;
import com.workshop.exampleapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDelegate {
    @Autowired
    ProductRepository repository;

    public List<Product> getProducts() {
        return (List<Product>) repository.findAll();
    }

    public Product getProduct(Long productID) {
        try {
            return repository.findById(productID).get();
        } catch (Exception exception) {
            throw new ProductNotFoundException();
        }
    }

    public Product addNewProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long productID, Product newProduct) {
        if (repository.existsById(productID)) {
            return repository.save(newProduct);
        } else {
            throw new ProductBadRequestException();
        }
    }

    public void deleteProduct(Long productID) {
        if (repository.existsById(productID)) {
            repository.deleteById(productID);
        } else {
            throw new ProductBadRequestException();
        }
    }
}
