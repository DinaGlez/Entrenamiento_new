package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import java.util.List;
public interface ProductoService {
    void insertProducto(Producto producto);
    void AddProducto(ProductoDTO productoDTO);

    void deleteProducto (int producto);
    Producto getProducto(int idproducto);
    List<ProductoDTO> getProductos();
    void updateProducto(int id,Producto producto);
}
