package com.inditex.prueba.service.impl;

import com.inditex.prueba.entity.Brand;
import com.inditex.prueba.repository.BrandRepository;
import com.inditex.prueba.service.BrandService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;
    
    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getBrand(Integer id) {
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.get();
    }

    @Override
    public Brand postBrand(Brand brand) {
        Brand brandSaved = brandRepository.save(brand);
        return brandSaved;
    }
    
    
}
