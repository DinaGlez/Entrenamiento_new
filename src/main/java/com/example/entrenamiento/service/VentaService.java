package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Venta;


import java.util.List;
public interface VentaService {
    void insertVenta(Venta venta);
    //void addProductoVenta(int idproducto,int venta);
    List<VentaDTO> getVentas();
}
