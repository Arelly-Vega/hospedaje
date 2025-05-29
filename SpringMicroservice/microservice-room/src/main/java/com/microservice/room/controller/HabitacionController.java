package com.microservice.room.controller;

import com.microservice.room.dto.HabitacionDTO;
import com.microservice.room.entities.EstadoHabitacion;
import com.microservice.room.entities.Habitacion;
import com.microservice.room.entities.TipoHabitacion;
import com.microservice.room.http.request.ActualizarHabitacionRequest;
import com.microservice.room.http.response.HabitacionResponse;
import com.microservice.room.http.response.TipoHabitacionResponse;
import com.microservice.room.persistence.IHabitacionRepository;
import com.microservice.room.persistence.ITipoHabitacionRepository;
import com.microservice.room.service.IHabitacionService;
import com.microservice.room.service.ITipoHabitacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/habitacion")
@RequiredArgsConstructor
public class HabitacionController {

    @Autowired
    private final IHabitacionService habitacionService;
    private final ITipoHabitacionRepository tipoRepo;
    private final IHabitacionRepository habitacionRepo;

    @GetMapping("/listar")
    public Iterable<Habitacion> obtenerHabitaciones() {
        return habitacionService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable int id) {
        return habitacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Habitacion crearHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionService.create(habitacion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HabitacionResponse> actualizarHabitacion(
            @PathVariable int id,
            @Valid @RequestBody ActualizarHabitacionRequest req) {

        // 1. Obtengo la habitación existente
        Habitacion hab = habitacionRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Habitación no encontrada"));

        // 2. Obtengo el tipo de habitación que llega por ID
        TipoHabitacion tipo = tipoRepo.findById(req.getTipoId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "TipoHabitacion no existe"));

        // 3. Actualizo los campos
        hab.setNumero(req.getNumero());
        hab.setEstado(req.getEstado());
        hab.setTipo(tipo);

        // 4. Guardo y preparo la respuesta
        Habitacion saved = habitacionRepo.save(hab);
        HabitacionResponse resp = HabitacionResponse.builder()
                .id(saved.getId())
                .numero(saved.getNumero())
                .estado(saved.getEstado())
                .tipo(TipoHabitacionResponse.builder()
                        .id(tipo.getId())
                        .nombre(tipo.getNombre())
                        .descripcion(tipo.getDescripcion())
                        .precio(tipo.getPrecio())
                        .build())
                .build();

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable int id) {
        return habitacionService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/disponibles")
    public Iterable<Habitacion> obtenerDisponibles() {
        return habitacionService.findDisponibles();
    }

    @GetMapping("/buscar/ocupadas")
    public Iterable<Habitacion> obtenerOcupadas() {
        return habitacionService.findOcupadas();
    }
}
