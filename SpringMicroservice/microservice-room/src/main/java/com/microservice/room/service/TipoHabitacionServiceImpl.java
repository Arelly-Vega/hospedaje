package com.microservice.room.service;

import com.microservice.room.entities.TipoHabitacion;
import com.microservice.room.persistence.ITipoHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoHabitacionServiceImpl implements ITipoHabitacionService{

    @Autowired
    private final ITipoHabitacionRepository tipoHabitacionRepository;

    @Override
    public Iterable<TipoHabitacion> findAll() {
        return tipoHabitacionRepository.findAll();
    }

    @Override
    public Optional<TipoHabitacion> findById(int id) {
        return tipoHabitacionRepository.findById(id);
    }

    @Override
    public TipoHabitacion create(TipoHabitacion tipo) {
        return tipoHabitacionRepository.save(tipo);
    }

    @Override
    public TipoHabitacion update(int id, TipoHabitacion tipo) {
        return tipoHabitacionRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(tipo.getNombre());
                    existing.setDescripcion(tipo.getDescripcion());
                    existing.setPrecio(tipo.getPrecio());
                    return tipoHabitacionRepository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el TipoHabitacion con id " + id));
    }

    @Override
    public boolean delete(int id) {
        if (tipoHabitacionRepository.existsById(id)) {
            tipoHabitacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
