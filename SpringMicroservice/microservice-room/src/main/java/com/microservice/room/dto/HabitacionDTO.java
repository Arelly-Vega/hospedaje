package com.microservice.room.dto;

import com.microservice.room.entities.EstadoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {
    private Integer id;
    private String numero;
    private EstadoHabitacion estado;
    private Integer tipoId;
}
