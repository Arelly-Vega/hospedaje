package com.microservice.product.service;

import com.microservice.product.dto.MovimientoDTO;
import com.microservice.product.entities.Lote;
import com.microservice.product.entities.Movimiento;
import com.microservice.product.entities.Producto;
import com.microservice.product.entities.TipoMovimiento;
import com.microservice.product.persistence.ILoteRepository;
import com.microservice.product.persistence.IMovimientoRepository;
import com.microservice.product.persistence.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements IMovimientoService{

    @Autowired
    private final IMovimientoRepository movimientoRepository;

    @Autowired
    private final IProductoRepository productoRepository;

    @Autowired
    private final ILoteRepository loteRepository;

    public Movimiento registrarMovimiento(MovimientoDTO movimiento) {
        Producto producto = productoRepository.findById(movimiento.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        String loteCodigo = movimiento.getLote().getCodigo();
        var fechaVencimiento = movimiento.getLote().getFechaVencimiento();

        // Buscar lote por código + producto + fecha de vencimiento
        Optional<Lote> loteOpt = loteRepository.findByCodigoAndProductoAndFechaVencimiento(loteCodigo, producto, fechaVencimiento);

        Lote lote;
        if (loteOpt.isPresent()) {
            lote = loteOpt.get();

            if (movimiento.getTipoMovimiento() == TipoMovimiento.ENTRADA) {
                lote.setCantidadDisponible(lote.getCantidadDisponible() + movimiento.getCantidad());
            } else {
                if (lote.getCantidadDisponible() < movimiento.getCantidad()) {
                    throw new RuntimeException("Stock insuficiente en lote");
                }
                lote.setCantidadDisponible(lote.getCantidadDisponible() - movimiento.getCantidad());
            }

        } else {
            if (movimiento.getTipoMovimiento() == TipoMovimiento.SALIDA) {
                throw new RuntimeException("No existe lote para salida");
            }

            // Crear nuevo lote
            lote = Lote.builder()
                    .codigo(loteCodigo)
                    .producto(producto)
                    .fechaVencimiento(fechaVencimiento)
                    .cantidadDisponible(movimiento.getCantidad())
                    .build();
        }

        // Guardar lote
        loteRepository.save(lote);

        // Actualizar stock total del producto
        if (movimiento.getTipoMovimiento() == TipoMovimiento.ENTRADA) {
            producto.setStockActual(producto.getStockActual() + movimiento.getCantidad());
        } else {
            producto.setStockActual(producto.getStockActual() - movimiento.getCantidad());
        }

        productoRepository.save(producto);

        // Guardar movimiento
        Movimiento mov = Movimiento.builder()
                .producto(producto)
                .lote(lote)
                .cantidad(movimiento.getCantidad())
                .tipoMovimiento(movimiento.getTipoMovimiento())
                .fecha(movimiento.getFecha())
                .build();

        Movimiento guardado = movimientoRepository.save(mov);

        // Verificar stock mínimo
        if (producto.getStockMinimo() != null && producto.getStockActual() <= producto.getStockMinimo()) {
            System.out.println("Advertencia: El producto '" + producto.getNombre() + "' ha alcanzado el stock mínimo.");
        }

        return guardado;
    }
}
