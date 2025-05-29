package com.microservice.room.service;

import com.microservice.room.entities.EstadoHabitacion;
import com.microservice.room.entities.Habitacion;
import com.microservice.room.persistence.IHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements IHabitacionService{

    @Autowired
    private final IHabitacionRepository habitacionRepository;

    @Override
    public Iterable<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitacion> findById(int id) {
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitacion create(Habitacion habitacion) {
        //falta añadir validaciones para crear habitacion
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion update(int id, Habitacion habitacion) {
        return habitacionRepository.findById(id)
                .map(existing -> {
                    existing.setNumero(habitacion.getNumero());
                    existing.setEstado(habitacion.getEstado());
                    existing.setTipo(habitacion.getTipo());
                    return habitacionRepository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la habitación con id " + id));
    }

    @Override
    public boolean delete(int id) {
        if (habitacionRepository.existsById(id)) {
            habitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<Habitacion> findByEstado(EstadoHabitacion estado) {
        return habitacionRepository.findByEstado(estado);
    }
}
