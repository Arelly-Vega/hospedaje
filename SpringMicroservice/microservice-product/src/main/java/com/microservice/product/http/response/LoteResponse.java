package com.microservice.product.http.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LoteResponse {
    Integer id;
    String codigo;
    LocalDate fechaVencimiento;
    Integer cantidadDisponible;
}
