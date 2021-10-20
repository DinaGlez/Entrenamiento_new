package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ProductoDAO extends ReactiveMongoRepository<Producto, String> {
}
