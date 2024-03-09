package com.inditex.prueba.service;

import com.inditex.prueba.entity.Price;
import java.util.Optional;

public interface PriceService {
    Optional<Price> getPrice(Integer priceId);
    Optional<Price> createPrice(Price newPrice);
    Optional<Price> updatePrice(Integer priceId, Price updatedPrice);
    void deletePrice(Integer priceId);
}
