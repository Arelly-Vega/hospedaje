package com.microservice.room.client;

import com.microservice.room.dto.ReservationDTO;
import com.microservice.room.http.request.CrearReservacionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-reserva", path = "localhost:8081/api/student")
public interface ReservacionClient {

     @PostMapping
     ReservationDTO createReservation(@RequestBody CrearReservacionRequest req);

}
