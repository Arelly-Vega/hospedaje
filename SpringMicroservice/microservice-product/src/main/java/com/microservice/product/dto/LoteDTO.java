package com.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoteDTO {
    private Integer id;
    private String codigo;
    private LocalDate fechaVencimiento;
    private Integer cantidadDisponible;
    private Integer productoId;
}
