package com.microservice.room.http.response;

import com.microservice.room.entities.EstadoHabitacion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitacionResponse {
    private Integer id;
    private String numero;
    private EstadoHabitacion estado;
    private TipoHabitacionResponse tipo;
}
