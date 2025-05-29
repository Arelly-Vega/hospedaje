package com.microservice.room.http.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearReservacionRequest {
    @NotNull
    private Integer habitacionId;
    @NotNull
    private Integer huespedId;
    @NotNull
    private LocalDate checkIn;
    @NotNull
    private LocalDate checkOut;
}
