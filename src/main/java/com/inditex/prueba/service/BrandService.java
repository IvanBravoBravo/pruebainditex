package com.inditex.prueba.service;

import com.inditex.prueba.entity.Brand;

public interface BrandService {
    Brand getBrand(Integer id);
    Brand postBrand(Brand brand);
}
