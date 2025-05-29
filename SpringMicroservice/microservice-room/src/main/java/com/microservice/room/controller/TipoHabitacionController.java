package com.microservice.room.controller;

import com.microservice.room.entities.TipoHabitacion;
import com.microservice.room.persistence.ITipoHabitacionRepository;
import com.microservice.room.service.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipo-habitacion")
@RequiredArgsConstructor
public class TipoHabitacionController {

    @Autowired
    private final ITipoHabitacionRepository tipoHabitacionRepository;
    private final ITipoHabitacionService tipoHabitacionService;


    @GetMapping("/listar")
    public Iterable<TipoHabitacion> listarTipo() {
        return tipoHabitacionService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoHabitacion> obtenerPorId(@PathVariable int id) {
        return tipoHabitacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public TipoHabitacion crearTipo(@RequestBody TipoHabitacion tipo) {
        TipoHabitacion creado = tipoHabitacionService.create(tipo);
        return ResponseEntity.ok(creado).getBody();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoHabitacion> actualizarTipo(@PathVariable int id, @RequestBody TipoHabitacion tipo) {
        try {
            TipoHabitacion actualizado = tipoHabitacionService.update(id, tipo);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTipo(@PathVariable int id) {
        return tipoHabitacionService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
