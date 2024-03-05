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
@Table(name = "BRANDS")
@NamedQuery(name = "Brand.findByName",
    query = "select b from Brand b where b.brandName = ?1")
public class Brand implements Serializable {

    @Id
    @Column(name="BRAND_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
    
    @Column(name="BRAND_NAME")
    private String brandName;
}
