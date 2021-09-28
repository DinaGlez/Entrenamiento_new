package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Venta;


import java.util.List;
public interface VentaService {
    int insertVenta(VentaDTO ventaDTO);
    List<VentaDTO> getVentas();
    List<DetalleVentaDTO> GetListaDetallleById(int idventa);
     VentaDTO getVenta(int idventa);
}
