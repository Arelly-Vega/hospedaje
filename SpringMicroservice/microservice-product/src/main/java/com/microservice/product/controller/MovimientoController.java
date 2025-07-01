package com.microservice.product.controller;

import com.microservice.product.dto.MovimientoDTO;
import com.microservice.product.entities.Movimiento;
import com.microservice.product.service.IMovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimiento")
@RequiredArgsConstructor
public class MovimientoController {
    private final IMovimientoService movimientoService;

    @PostMapping("/registrar")
    public Movimiento registrar(@RequestBody MovimientoDTO movimiento) {
        return movimientoService.registrarMovimiento(movimiento);
    }
}
