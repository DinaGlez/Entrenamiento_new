package com.example.entrenamiento.service;

import com.example.entrenamiento.model.DetalleVenta;
import com.example.entrenamiento.model.Venta;

public interface DetalleVentaService {
    void addProducto(Venta venta, int idproducto);
}
