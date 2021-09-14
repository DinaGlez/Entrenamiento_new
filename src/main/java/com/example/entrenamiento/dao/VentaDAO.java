package com.example.entrenamiento.dao;

import com.example.entrenamiento.model.Venta;

import java.util.List;

public interface VentaDAO {
    List<Venta> getVentas();
    void insertVenta(Venta venta);

}
