package com.microservice.product.service;

import com.microservice.product.dto.ProductoDTO;
import com.microservice.product.dto.ProductoDetalleDTO;
import com.microservice.product.dto.LoteDTO;
import com.microservice.product.entities.Producto;
import com.microservice.product.entities.Lote;
import com.microservice.product.persistence.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private final IProductoRepository productoRepository;


    @Override
    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream()
                .map(p -> ProductoDTO.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .stockActual(p.getStockActual())
                        .stockMinimo(p.getStockMinimo())
                        .build())
                .toList();
    }

    @Override
    public ProductoDetalleDTO obtenerDetalle(Integer id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return ProductoDetalleDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .stockActual(p.getStockActual())
                .stockMinimo(p.getStockMinimo())
                .lotes(p.getLotes().stream().map(l ->
                        LoteDTO.builder()
                                .id(l.getId())
                                .codigo(l.getCodigo())
                                .fechaVencimiento(l.getFechaVencimiento())
                                .cantidadDisponible(l.getCantidadDisponible())
                                .productoId(p.getId())
                                .build()).toList())
                .build();
    }

    @Override
    public ProductoDTO guardar(ProductoDTO dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .stockActual(dto.getStockActual())
                .stockMinimo(dto.getStockMinimo())
                .build();
        Producto guardado = productoRepository.save(p);
        return ProductoDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .stockActual(guardado.getStockActual())
                .stockMinimo(guardado.getStockMinimo())
                .build();
    }
}
