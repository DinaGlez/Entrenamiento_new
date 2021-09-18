package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VentaDAO extends CrudRepository<Venta,Integer> {

}
