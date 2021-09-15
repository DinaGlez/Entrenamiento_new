package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
 @Autowired
 ProductoDAO productoDAO;
    @Override
    public void insertProducto(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteProducto(int idproducto) {
        productoDAO.deleteById(idproducto);
    }

    @Override
    public Producto getProducto(int idproducto) {
        ;
        return null;
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos=new ArrayList<>();
        productoDAO.findAll().forEach(productos::add);
        return productos;
    }

    @Override
    public void updateProducto(Producto producto) {
        productoDAO.save(producto);

    }
}
