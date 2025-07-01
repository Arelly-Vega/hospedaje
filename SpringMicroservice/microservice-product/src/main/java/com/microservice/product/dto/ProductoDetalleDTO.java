package com.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDetalleDTO {
    private Integer id;
    private String nombre;
    private Integer stockActual;
    private Integer stockMinimo;
    private List<LoteDTO> lotes;
}
