package com.microservice.product.persistence;

import com.microservice.product.entities.Lote;
import com.microservice.product.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ILoteRepository extends JpaRepository <Lote, Integer> {

    Optional<Lote> findByCodigoAndProductoAndFechaVencimiento(String codigo, Producto producto, LocalDate fechaVencimiento);
}
