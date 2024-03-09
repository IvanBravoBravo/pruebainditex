package com.inditex.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Integer productId;
    
    @Column(name="PRODUCT_NAME")
    private String productName;
}
