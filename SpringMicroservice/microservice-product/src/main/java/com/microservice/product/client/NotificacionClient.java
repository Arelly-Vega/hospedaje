package com.microservice.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "msvc-notification", path = "/api/alets")
public class NotificacionClient {
//    @PostMapping
//    void sendLowStockAlert(@RequestBody AlertaBajoStock alert);
}
