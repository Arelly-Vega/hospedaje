package com.microservice.product.http.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarProductoRequest {
    @NotNull
    Integer id;

    @NotBlank
    String nombre;

    @NotNull
    Integer stockMinimo;
}
