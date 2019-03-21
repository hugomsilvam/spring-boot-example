package com.workshop.exampleapi.repository;

import com.workshop.exampleapi.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
}
