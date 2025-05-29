package com.microservice.room.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Integer id;
    private Integer habitacionId;
    private Integer huespedId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String estado;
}
