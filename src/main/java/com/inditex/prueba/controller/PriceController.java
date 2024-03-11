package com.inditex.prueba.controller;

import com.inditex.prueba.dto.PrecioFinalDTO;
import com.inditex.prueba.dto.PriceDTO;
import com.inditex.prueba.entity.Price;
import com.inditex.prueba.exception.PrecioNotFoundException;
import com.inditex.prueba.service.PriceService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    private final ModelMapper modelMapper;

    @Autowired
    public PriceController(PriceService priceService, ModelMapper modelMapper) {
        this.priceService = priceService;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping
    public ResponseEntity<PrecioFinalDTO> getPrecioFinal(
            @RequestParam("fecha_aplicacion") 
                @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") LocalDateTime fechaAplicacion,
            @RequestParam("id_producto") Integer idProducto,
            @RequestParam("id_cadena") Integer idCadena) throws PrecioNotFoundException {
        log.debug("fecha_aplicacion : {}, id_producto: {}, id_cadena: {}",fechaAplicacion,idProducto, idCadena);
        Optional<Price> price = priceService.getPrecioFinal(fechaAplicacion, idProducto, idCadena);
        if(price.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(convertToPrecioDto(price.get()));
        }else{
            throw PrecioNotFoundException.createWith(fechaAplicacion, idProducto, idCadena);
        }
        
    }

    @GetMapping("/{priceId}")
    public ResponseEntity<PriceDTO> getPrice(@PathVariable Integer priceId) {
        Optional<Price> price = priceService.getPrice(priceId);
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(price.get()));
    }

    @PostMapping
    public ResponseEntity<PriceDTO> createPrice(@RequestBody PriceDTO newPrice) {
        Optional<Price> price = priceService.createPrice(convertToEntity(newPrice));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(price.get()));
    }

    @PutMapping("/{priceId}")
    public ResponseEntity<PriceDTO> updatePrice(@PathVariable Integer priceId, @RequestBody PriceDTO updatedPrice) {
        Optional<Price> price = priceService.updatePrice(priceId,convertToEntity(updatedPrice));
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(price.get()));
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<Void> deletePrice(@PathVariable Integer priceId) {
        priceService.deletePrice(priceId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Price convertToEntity(PriceDTO priceDTO) {
        Price price = modelMapper.map(priceDTO, Price.class);
        return price;
    }

    private PriceDTO convertToDto(Price price) {
        PriceDTO priceDTO = modelMapper.map(price, PriceDTO.class);
        return priceDTO;
    }
    
    private PrecioFinalDTO convertToPrecioDto(Price price) {
        PrecioFinalDTO precioFinalDTO = modelMapper.map(price, PrecioFinalDTO.class);
        return precioFinalDTO;
    }
}
