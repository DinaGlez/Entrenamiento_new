package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Venta;


import java.util.List;
public interface VentaService {
    void insertVenta(Venta venta);
    List<Venta> GetVentas();
}
