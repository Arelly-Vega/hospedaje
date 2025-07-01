package com.microservice.product.persistence;

import com.microservice.product.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
//    Optional<Producto> findByNombre(String nombre);
}
