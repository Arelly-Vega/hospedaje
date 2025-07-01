package com.microservice.product.http.request;

import com.microservice.product.entities.TipoMovimiento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrarMovimientoRequest {
    @NotNull Integer productoId;
    @NotBlank String loteCodigo;
    @NotNull
    LocalDate fechaVencimiento;
    @NotNull Integer cantidad;
    @NotNull
    TipoMovimiento tipoMovimiento;
    String observacion;
}
