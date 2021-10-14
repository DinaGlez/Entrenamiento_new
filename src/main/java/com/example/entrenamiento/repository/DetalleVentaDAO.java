package com.example.entrenamiento.repository;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.model.DetalleVenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface DetalleVentaDAO extends ReactiveCrudRepository<DetalleVenta, Integer> {
    List<DetalleVentaDTO> findDetalleVentaByVenta(int idventa);
}
