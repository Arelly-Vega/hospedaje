package com.microservice.room.http.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DisponibilidadResponse {
    private List<HabitacionResponse> habitaciones;

}
