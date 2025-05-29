package com.microservice.room.persistence;

import com.microservice.room.entities.EstadoHabitacion;
import com.microservice.room.entities.Habitacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHabitacionRepository extends CrudRepository<Habitacion, Integer> {
    List<Habitacion> findByEstado (EstadoHabitacion estado);
}
