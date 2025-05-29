package com.microservice.room;

import com.microservice.room.entities.EstadoHabitacion;
import com.microservice.room.entities.Habitacion;
import com.microservice.room.entities.TipoHabitacion;
import com.microservice.room.persistence.IHabitacionRepository;
import com.microservice.room.persistence.ITipoHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RequiredArgsConstructor
public class MicroserviceRoomApplication {

	private final ITipoHabitacionRepository tipoRepo;
	private final IHabitacionRepository habitacionRepo;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRoomApplication.class, args);
	}

	@Bean
	CommandLineRunner initData() {
		return args -> {
			// 1. Crear tipos de habitación
			TipoHabitacion simple = TipoHabitacion.builder()
					.nombre("SIMPLE")
					.descripcion("Cama individual")
					.precio(50.0)
					.build();
			TipoHabitacion doble = TipoHabitacion.builder()
					.nombre("DOBLE")
					.descripcion("Cama matrimonial")
					.precio(80.0)
					.build();
			TipoHabitacion suite = TipoHabitacion.builder()
					.nombre("MATRIMONIAL")
					.descripcion("Cama Suite")
					.precio(150.0)
					.build();


			tipoRepo.save(simple);
			tipoRepo.save(doble);
			tipoRepo.save(suite);

			// 2. Crear habitaciones vinculadas a esos tipos
			habitacionRepo.save(Habitacion.builder()
					.numero("101")
					.estado(EstadoHabitacion.DISPONIBLE)
					.tipo(simple)
					.build());

			habitacionRepo.save(Habitacion.builder()
					.numero("102")
					.estado(EstadoHabitacion.DISPONIBLE)
					.tipo(doble)
					.build());

			habitacionRepo.save(Habitacion.builder()
					.numero("201")
					.estado(EstadoHabitacion.DISPONIBLE)
					.tipo(suite)
					.build());

			habitacionRepo.save(Habitacion.builder()
					.numero("202")
					.estado(EstadoHabitacion.OCUPADO)
					.tipo(doble)
					.build());

			System.out.println("Datos de prueba cargados en Habitacion y TipoHabitacion");
		};
	}
}
