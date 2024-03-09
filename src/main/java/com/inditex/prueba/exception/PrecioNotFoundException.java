package com.inditex.prueba.exception;

import java.time.LocalDateTime;

public class PrecioNotFoundException extends Exception {

    private LocalDateTime fechaAplicacion;
    private Integer idProducto;
    private Integer idCadena;

    public static PrecioNotFoundException createWith(LocalDateTime fechaAplicacion, Integer idProducto, Integer idCadena) {
        return new PrecioNotFoundException(fechaAplicacion, idProducto, idCadena);
    }

    private PrecioNotFoundException(LocalDateTime fechaAplicacion, Integer idProducto, Integer idCadena) {
        this.fechaAplicacion = fechaAplicacion;
        this.idProducto = idProducto;
        this.idCadena = idCadena;
    }

    @Override
    public String getMessage() {
        return "Precio fecha: '" + fechaAplicacion + "', idProducto: '" + idProducto + "', idCadena: '" + idCadena + "' not found";
    }
}
