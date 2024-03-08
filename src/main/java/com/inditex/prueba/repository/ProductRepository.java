package com.inditex.prueba.repository;

import com.inditex.prueba.entity.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String productName);
}
