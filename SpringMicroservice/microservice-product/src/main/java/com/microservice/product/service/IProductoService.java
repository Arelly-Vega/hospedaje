package com.microservice.product.service;

import com.microservice.product.dto.ProductoDTO;
import com.microservice.product.dto.ProductoDetalleDTO;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<ProductoDTO> listar();
    ProductoDetalleDTO obtenerDetalle(Integer id);
    ProductoDTO guardar(ProductoDTO dto);
}
