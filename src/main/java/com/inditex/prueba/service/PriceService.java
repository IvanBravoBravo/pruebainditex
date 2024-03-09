package com.inditex.prueba.service;

import com.inditex.prueba.entity.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> getPrecioFinal(LocalDateTime fechaAplicacion, Integer idProducto, Integer idCadena);
    Optional<Price> getPrice(Integer priceId);
    Optional<Price> createPrice(Price newPrice);
    Optional<Price> updatePrice(Integer priceId, Price updatedPrice);
    void deletePrice(Integer priceId);
}
