package com.inditex.prueba.repository;

import com.inditex.prueba.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
     public Brand findByName(String name);
}
