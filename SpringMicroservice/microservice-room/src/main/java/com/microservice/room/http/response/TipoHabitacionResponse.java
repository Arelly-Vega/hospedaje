package com.microservice.room.http.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoHabitacionResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
