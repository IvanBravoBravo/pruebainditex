package com.inditex.prueba.controller;

import com.inditex.prueba.dto.ProductDTO;
import com.inditex.prueba.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inditex.prueba.entity.Product;
import com.inditex.prueba.exception.ProductExistException;
import com.inditex.prueba.exception.ProductNotFoundException;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId) throws ProductNotFoundException {
        Optional<Product> product = productService.getProduct(productId);
        if(product.isPresent()){
            log.debug("Producto encontrado");
            return ResponseEntity.status(HttpStatus.OK).body(convertToDto(product.get()));
        }else{
            log.debug("ProductNotFoundException");
            throw ProductNotFoundException.createWith(productId);
        }
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO newProduct) throws ProductExistException {
        Optional<Product> product = productService.createProduct(convertToEntity(newProduct));
        if(product.isPresent()){
            log.debug("Producto creado");
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(product.get()));
        }else{
            log.debug("ProductExistException");
            throw ProductExistException.createWith(newProduct.getProductName());
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer productId, @RequestBody ProductDTO updatedProduct) throws ProductNotFoundException {
        Optional<Product> product = productService.updateProduct(productId,convertToEntity(updatedProduct));
        if(product.isPresent()){
            log.debug("Producto modificado");
            return ResponseEntity.status(HttpStatus.OK).body(convertToDto(product.get()));
        }else{
            log.debug("ProductNotFoundException");
            throw ProductNotFoundException.createWith(productId);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
        log.debug("producto eliminado");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return product;
    }

    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }
}
