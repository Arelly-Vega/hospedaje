package com.microservice.room.persistence;

import com.microservice.room.entities.TipoHabitacion;
import org.springframework.data.repository.CrudRepository;

public interface ITipoHabitacionRepository extends CrudRepository<TipoHabitacion, Integer> {

}
