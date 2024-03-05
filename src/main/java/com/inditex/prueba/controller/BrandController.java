package com.inditex.prueba.controller;

import com.inditex.prueba.dto.BrandDTO;
import com.inditex.prueba.service.BrandService;
import com.inditex.prueba.entity.Brand;
import jakarta.validation.constraints.NotNull;
import java.security.NoSuchAlgorithmException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@Slf4j
public class BrandController {

    private final BrandService brandService;

    private final ModelMapper modelMapper;
    
    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping(path = "/brand/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<BrandDTO> getBrand(@NotNull @PathVariable("id") Integer id){
        Brand brand = brandService.getBrand(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(brand));
    }
    
    @PostMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BrandDTO> postBrand(@RequestBody BrandDTO brandDTO) {
        Brand brand = brandService.postBrand(convertToEntity(brandDTO));
        BrandDTO brandReturn = convertToDto(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandReturn);
    }
    
    private Brand convertToEntity(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        return brand;
    }

    private BrandDTO convertToDto(Brand brand) {
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
        return brandDTO;
    }
}
