package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
public interface ProductoService {

    public Flux<ProductoDTO> getAll();

    public Mono<ProductoDTO> getById(String idproducto);

    //Flux<Producto> findByName(String name);

    public Mono<ProductoDTO> save(Mono<ProductoDTO> productoDTO);

    public Mono<ProductoDTO> update(Mono<ProductoDTO> productoDTO, String id);

}
