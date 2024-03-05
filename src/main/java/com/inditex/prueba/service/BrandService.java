package com.inditex.prueba.service;

import com.inditex.prueba.entity.Brand;
import com.inditex.prueba.exception.BrandExistException;
import com.inditex.prueba.exception.BrandNotFoundException;

public interface BrandService {
    Brand getBrand(Integer id) throws BrandNotFoundException;
    Brand postBrand(Brand brand) throws BrandExistException;
}
