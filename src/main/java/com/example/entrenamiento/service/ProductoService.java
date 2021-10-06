package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import java.util.List;
public interface ProductoService {

    void AddProducto(ProductoDTO productoDTO);
    void deleteProducto (int producto) throws Exception;
    Producto getProductoById(int idproducto);
    ProductoDTO getProductoDTOById(int idproducto);
    Producto convertToProducto(ProductoDTO productoDTO);
    List<ProductoDTO> getProductos();
    void updateProducto(int id,ProductoDTO producto);
    void updateProducto(Producto producto);
    boolean ifInventarioDisponible(int idproducto,int cantidad);
}
