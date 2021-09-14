package com.example.entrenamiento.dao;

import com.example.entrenamiento.model.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductoDAO extends CrudRepository<Producto, Integer> {
}
