package com.example.entrenamiento.repository;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.model.DetalleVenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetalleVentaDAO extends CrudRepository<DetalleVenta, Integer> {
    List<DetalleVentaDTO> findDetalleVentaByVenta(int idventa);
}
