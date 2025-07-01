package com.microservice.product.dto;

import com.microservice.product.entities.Lote;
import com.microservice.product.entities.Producto;
import com.microservice.product.entities.TipoMovimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDTO {
    private Integer id;
    private Integer cantidad;
    private TipoMovimiento tipoMovimiento;
    private LocalDateTime fecha;
    private String observacion;
    private Integer productoId;
    private LoteDTO lote;
}
