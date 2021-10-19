package com.example.entrenamiento.service.Impl;



import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import com.example.entrenamiento.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoDAO productoDAO;

 @Override
 public Flux<Producto> getAll() {
     return productoDAO.findAll();
 }

    @Override
    public Mono<Producto> getById(int idproducto) {
        return productoDAO.findById(idproducto);
    }

    @Override
    public Mono<Producto> save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public Mono<Producto> update(Producto producto) {
        return productoDAO.save(producto);
    }

}