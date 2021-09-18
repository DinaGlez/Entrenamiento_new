package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ProductoDAO extends JpaRepository<Producto, Integer> {
}
