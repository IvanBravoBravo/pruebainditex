package com.inditex.prueba.service.impl;

import com.inditex.prueba.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.inditex.prueba.entity.Price;
import com.inditex.prueba.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;
    
    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    
    @Override
    public Optional<Price> getPrecioFinal(LocalDateTime fechaAplicacion, Integer idProducto, Integer idCadena) {
        List<Price> prices = priceRepository.findPrecioFinal(fechaAplicacion, idProducto, idCadena);
        return prices.stream().findFirst();
    }
    
    @Override
    public Optional<Price> getPrice(Integer priceId){
        return priceRepository.findById(priceId);
    }
    
    @Override
    public Optional<Price> createPrice(Price newPrice){
        return Optional.of(priceRepository.save(newPrice));
    }
    
    @Override
    public Optional<Price> updatePrice(Integer priceId, Price updatedPrice){
        return Optional.of(priceRepository.save(updatedPrice));
    }
    
    @Override
    public void deletePrice(Integer priceId){
        priceRepository.deleteById(priceId);
    }
}