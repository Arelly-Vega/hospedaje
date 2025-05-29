package com.microservice.room.http.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearHabitacionRequest {
    @NotBlank
    private String numero;

    @NotNull
    private Integer tipoId;
}
