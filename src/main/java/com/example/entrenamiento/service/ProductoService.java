package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
public interface ProductoService {

    public Flux<Producto> getAll();

    public Mono<Producto> getById(int idCliente);

    //Flux<Producto> findByName(String name);

    public Mono<Producto> save(Producto producto);

    public Mono<Producto> update(Producto producto);

}
