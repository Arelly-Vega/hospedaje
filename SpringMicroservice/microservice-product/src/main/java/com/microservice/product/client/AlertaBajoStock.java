package com.microservice.product.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlertaBajoStock {
    Integer productoId;
    String productoNombre;
    Integer stockActual;
    Integer stockMinimo;
}
