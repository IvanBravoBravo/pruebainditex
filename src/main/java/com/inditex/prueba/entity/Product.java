package com.inditex.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCTS")
@NamedQuery(name = "Product.findByName",
    query = "select product from Product product where product.productName = ?1")
public class Product implements Serializable {
    @Id
    @Column(name="PRODUCT_ID")
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    
    @Column(name="PRODUCT_NAME")
    private String productName;
}
