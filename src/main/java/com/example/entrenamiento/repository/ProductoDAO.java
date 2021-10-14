package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ProductoDAO extends ReactiveCrudRepository<Producto, Integer> {
}
