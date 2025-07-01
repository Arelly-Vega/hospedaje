package com.microservice.product.persistence;

import com.microservice.product.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
