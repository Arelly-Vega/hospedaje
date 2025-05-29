package com.microservice.room.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

    @Column(name = "estado_habitacion_nombre")
    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estado;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion_id")
    private TipoHabitacion tipo;
}
