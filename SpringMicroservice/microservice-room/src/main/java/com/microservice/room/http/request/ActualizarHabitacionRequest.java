package com.microservice.room.http.request;

import com.microservice.room.entities.EstadoHabitacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarHabitacionRequest {

    @NotBlank
    private String numero;
    @NotNull
    private Integer tipoId;
    @NotNull
    private EstadoHabitacion estado;
}
