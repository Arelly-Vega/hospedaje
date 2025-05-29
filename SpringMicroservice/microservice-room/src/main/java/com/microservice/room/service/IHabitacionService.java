package com.microservice.room.service;

import com.microservice.room.entities.EstadoHabitacion;
import com.microservice.room.entities.Habitacion;

import java.util.Optional;

public interface IHabitacionService {

    Iterable<Habitacion> findAll();

    Optional<Habitacion> findById(int id);

    Habitacion create(Habitacion habitacion);

    Habitacion update(int id, Habitacion habitacion);

    boolean delete(int id);

    Iterable<Habitacion> findByEstado(EstadoHabitacion estado);

    default Iterable<Habitacion> findDisponibles() {
        return findByEstado(EstadoHabitacion.DISPONIBLE);
    }
    default Iterable<Habitacion> findOcupadas() {
        return findByEstado(EstadoHabitacion.OCUPADO);
    }
}
