package com.microservice.product.http.response;

import com.microservice.product.entities.TipoMovimiento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovimientoResponse {
    Integer id;
    Integer productoId;
    String loteCodigo;
    LocalDate fechaVencimiento;
    Integer cantidad;
    TipoMovimiento tipoMovimiento;
    LocalDateTime fechaMovimiento;
    String observacion;
    Integer stockActualizado;
//    Boolean avisoStockBajo;
}
