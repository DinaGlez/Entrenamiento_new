package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Venta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;
public interface ClienteService {
    public Flux<ClienteDTO> getAll();

    public Mono<ClienteDTO> getById(String idcliente);

    //Flux<Producto> findByName(String name);

    public Mono<ClienteDTO> save(Mono<ClienteDTO> idcliente);

    public Mono<ClienteDTO> update(Mono<ClienteDTO> idcliente, String id);


}
