package com.microservice.product.service;

import com.microservice.product.dto.MovimientoDTO;
import com.microservice.product.entities.Movimiento;

public interface IMovimientoService {
    Movimiento registrarMovimiento(MovimientoDTO movimiento);
}
