package com.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private Integer stockActual;
    private Integer stockMinimo;
}
