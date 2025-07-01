package com.microservice.product.controller;

import com.microservice.product.dto.ProductoDTO;
import com.microservice.product.dto.ProductoDetalleDTO;
import com.microservice.product.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping("/listar")
    public List<ProductoDTO> listar() {
        return productoService.listar();
    }

    @PostMapping("/guardar")
    public ProductoDTO guardar(@RequestBody ProductoDTO dto) {
        return productoService.guardar(dto);
    }

    @GetMapping("/detalle/{id}")
    public ProductoDetalleDTO detalle(@PathVariable Integer id) {
        return productoService.obtenerDetalle(id);
    }
}
