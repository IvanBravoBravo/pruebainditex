package com.inditex.prueba.repository;

import com.inditex.prueba.entity.Price;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findPrecioFinal(LocalDateTime fechaAplicacion, Integer idProducto, Integer idCadena);
}
