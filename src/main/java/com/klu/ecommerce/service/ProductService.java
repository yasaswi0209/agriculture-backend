package com.klu.ecommerce.service;

import com.klu.ecommerce.entity.Product;
import com.klu.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product saveProduct(Product product) {
        return repo.save(product);
    }
}
