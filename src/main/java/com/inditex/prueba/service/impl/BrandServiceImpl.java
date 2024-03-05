package com.inditex.prueba.service.impl;

import com.inditex.prueba.entity.Brand;
import com.inditex.prueba.exception.BrandExistException;
import com.inditex.prueba.exception.BrandNotFoundException;
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
    public Brand getBrand(Integer id) throws BrandNotFoundException{
        Optional<Brand> brand = brandRepository.findById(id);
        if(brand.isPresent()){
            log.debug("brand is present");
            return brand.get();
        }else{
            log.debug("brand not found");
            throw BrandNotFoundException.createWith(id);
        }
    }

    @Override
    public Brand postBrand(Brand brand) throws BrandExistException {
        Brand brnd = brandRepository.findByName(brand.getBrandName());
        if (brnd != null && brnd.getBrandId()!=null) {
            log.warn("Brand existe.");
            throw BrandExistException.createWith(brnd.getBrandName());
        }
        Brand brandSaved = brandRepository.save(brand);
        return brandSaved;
    }
    
    
}
