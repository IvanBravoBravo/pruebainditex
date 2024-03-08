package com.inditex.prueba.service.impl;

import com.inditex.prueba.entity.Product;
import com.inditex.prueba.exception.ProductNotFoundException;
import com.inditex.prueba.repository.ProductRepository;
import com.inditex.prueba.service.ProductService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProduct(Integer productId){
        return productRepository.findById(productId);
    }

    @Override
    public Optional<Product> createProduct(Product newProduct) {
        Optional<Product> product = productRepository.findByName(newProduct.getProductName());
        if (product.isPresent()) {
            log.warn("Product existe.");
            return Optional.empty();
        } else{
            return Optional.of(productRepository.save(newProduct));
        }
    }
    
    @Override
    public Optional<Product> updateProduct(Integer productId, Product updatedProduct){
        if(productRepository.existsById(productId)){
            updatedProduct.setProductId(productId);
            return Optional.of(productRepository.save(updatedProduct));
        }else{
            log.warn("Product no existe.");
            return Optional.empty();
        }
    }
    
    @Override
    public void deleteProduct(Integer productId)throws ProductNotFoundException{
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }else{
            log.warn("Product no existe.");
            throw ProductNotFoundException.createWith(productId);
        }
    }

}
