package com.microservice.product;

import com.microservice.product.entities.Lote;
import com.microservice.product.entities.Movimiento;
import com.microservice.product.entities.Producto;
import com.microservice.product.entities.TipoMovimiento;
import com.microservice.product.persistence.ILoteRepository;
import com.microservice.product.persistence.IMovimientoRepository;
import com.microservice.product.persistence.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EnableFeignClients
@EnableDiscoveryClient
@RequiredArgsConstructor
@SpringBootApplication
public class MicroserviceProductApplication {

	private final IProductoRepository productoRepository;
	private final ILoteRepository loteRepository;
	private final IMovimientoRepository movimientoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		return args -> {

			// Crear producto
			Producto p1 = Producto.builder()
					.nombre("Paracetamol 500mg")
					.stockActual(0)
					.stockMinimo(20)
					.build();
			productoRepository.save(p1);

			// Crear lote asociado
			Lote l1 = Lote.builder()
					.codigo("LOTEX001")
					.producto(p1)
					.fechaVencimiento(LocalDate.of(2025, 12, 31))
					.cantidadDisponible(50)
					.build();
			loteRepository.save(l1);

			// Actualizar stock producto con base en lote
			p1.setStockActual(l1.getCantidadDisponible());
			productoRepository.save(p1);

			// Crear movimiento tipo ENTRADA
			Movimiento m1 = Movimiento.builder()
					.producto(p1)
					.lote(l1)
					.cantidad(50)
					.fecha(LocalDateTime.now())
					.tipoMovimiento(TipoMovimiento.ENTRADA)
					.observacion("Carga inicial de producto")
					.build();
			movimientoRepository.save(m1);

			System.out.println("Datos de ejemplo insertados correctamente.");
		};
	}

}
