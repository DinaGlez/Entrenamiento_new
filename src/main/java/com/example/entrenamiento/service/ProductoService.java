package com.example.entrenamiento.service;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
public interface ProductoService {

    void AddProducto(ProductoDTO productoDTO);
    Mono<Void> deleteProducto (int producto);
    Mono<Producto> getProductoById(int idproducto);
    //Mono<ProductoDTO> getProductoDTOById(int idproducto);
    //Producto convertToProducto(ProductoDTO productoDTO);
    Flux<Producto> getProductos();
    Mono<Producto> updateProducto(Producto producto);
   // void updateProducto(Producto producto);
}
