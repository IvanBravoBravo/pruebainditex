package com.inditex.prueba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PrecioFinalDTO {
    private Integer productId;
    private Integer brandId;
    private BigDecimal price;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;
    private String curr;

}
