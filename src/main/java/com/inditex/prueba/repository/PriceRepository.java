package com.inditex.prueba.repository;

import com.inditex.prueba.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    
}
