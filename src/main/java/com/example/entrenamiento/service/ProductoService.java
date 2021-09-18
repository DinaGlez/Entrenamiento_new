package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import java.util.List;
public interface ProductoService {

    void AddProducto(ProductoDTO productoDTO);
    void deleteProducto (int producto);
    ProductoDTO getProductoById(int idproducto);
    List<ProductoDTO> getProductos();
    void updateProducto(int id,ProductoDTO producto);
}
