package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface VentaDAO extends ReactiveCrudRepository<Venta,Integer> {
// List<DetalleVentaDTO> findDetallesById(int idventa);
}
