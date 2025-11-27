package com.klu.ecommerce.repository;

import com.klu.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // IMPORTANT — FIXED (case insensitive)
    List<Product> findByCategoryIgnoreCase(String category);

    // New methods for your new variables
    List<Product> findByBrand(String brand);

    List<Product> findByDiscountGreaterThan(double discount);

    List<Product> findByUnit(String unit);

    List<Product> findByQuantityGreaterThan(int quantity);

    List<Product> findByDescriptionContaining(String keyword);
}
