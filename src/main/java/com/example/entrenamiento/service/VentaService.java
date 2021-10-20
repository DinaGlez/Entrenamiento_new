package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Venta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
public interface VentaService {
    public Flux<VentaDTO> getAll();

    public Mono<VentaDTO> getById(int idventa);

    //Flux<Producto> findByName(String name);

    public Mono<VentaDTO> save(Mono<VentaDTO> ventaDTO);

    public Mono<VentaDTO> update(Mono<VentaDTO> ventaDTO, int id);
}
