package com.inditex.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name = "PRICES")
public class Price implements Serializable {

    @Id
    @Column(name="PRICE_LIST")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;
    
    @Column(name="BRAND_ID")
    private Integer brandId;
    
    @Column(name="START_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;
    
    @Column(name="END_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;
    
    @Column(name="PRODUCT_ID")
    private Integer productId;
    
    @Column(name="PRIORITY")
    private Integer priority;
    
    @Column(name="PRICE")
    private BigDecimal price;
    
    @Column(name="CURR")
    private String curr;
    
}