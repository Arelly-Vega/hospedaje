package com.microservice.product.http.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductoDetalleResponse {
    Integer id;
    String nombre;
    Integer stockActual;
    Integer stockMinimo;
    List<LoteResponse> lotes;
}
