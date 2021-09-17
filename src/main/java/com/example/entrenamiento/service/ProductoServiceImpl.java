package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void AddProducto(ProductoDTO productoDTO) {
        Producto producto = new ModelMapper().map(productoDTO, Producto.class);
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
    /*public List<Producto> getProductos() {
        List<ProductoDTO> productos = new ArrayList<>();
        productoDAO.findAll().forEach(productos::add);
        return productos;
    }*/
    public List<ProductoDTO> getProductos() {
        return ((List<Producto>) productoDAO
                .findAll())
                .stream()
                .map(this::convertToProductoDTO)
                .collect(Collectors.toList());
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