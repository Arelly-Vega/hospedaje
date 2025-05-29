package com.microservice.room.service;

import com.microservice.room.entities.TipoHabitacion;

import java.util.Optional;

public interface ITipoHabitacionService {
    Iterable<TipoHabitacion> findAll();

    Optional<TipoHabitacion> findById(int id);

    TipoHabitacion create(TipoHabitacion tipo);

    TipoHabitacion update(int id, TipoHabitacion tipo);

    boolean delete(int id);
}
