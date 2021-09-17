package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.ProductoDTO;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.*;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoDAO productoDAO;
    @Autowired
    private ModelMapper modelMapper;

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
        List<Producto> productos = new ArrayList<>();
        productoDAO.findAll().forEach(productos::add);
        return productos;
    }

    @Override
    public void updateProducto(Producto producto) {
        productoDAO.save(producto);

    }

    private ProductoDTO convertToProductoDTO(Producto producto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProductoDTO productoDTO=modelMapper.map(producto,ProductoDTO.class);
        return productoDTO;
    }
}