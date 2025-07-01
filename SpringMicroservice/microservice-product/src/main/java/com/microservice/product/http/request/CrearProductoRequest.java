package com.microservice.product.http.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearProductoRequest {

    @NotBlank
    String nombre;

    @NotNull
    Integer stockMinimo;
}
