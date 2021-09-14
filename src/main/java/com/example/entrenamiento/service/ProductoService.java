package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;


import java.util.List;
public interface ProductoService {
    void insertProducto(Producto producto);
    void deleteProducto (int producto);
    Producto getProducto(int idproducto);
    List<Producto> getProductos();
    void updateProducto(Producto producto);
}
