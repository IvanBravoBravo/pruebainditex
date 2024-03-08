package com.inditex.prueba.service;

import com.inditex.prueba.entity.Product;
import com.inditex.prueba.exception.ProductNotFoundException;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProduct(Integer productId);
    Optional<Product> createProduct(Product newProduct);
    Optional<Product> updateProduct(Integer productId, Product updatedProduct);
    void deleteProduct(Integer productId)throws ProductNotFoundException;
}
