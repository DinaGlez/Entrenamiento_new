package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoDAO productoDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void AddProducto(ProductoDTO productoDTO) {
        Producto producto = new ModelMapper().map(productoDTO, Producto.class);
        productoDAO.save(producto);

    }


    @Override
    public void deleteProducto(int idproducto) throws Exception{
        try{
            productoDAO.deleteById(idproducto);
        } catch (Exception e){
            throw new Exception("Imposible borrar cliente, tiene ventas asociadas", e.getCause());

        }
    }

    @Override
    public ProductoDTO getProductoDTOById(int idproducto) {
        return convertToProductoDTO(productoDAO.findById(idproducto).get());
    }
    @Override
    public Producto getProductoById(int idproducto) {
        return productoDAO.findById(idproducto).get();
    }
    @Override
        public List<ProductoDTO> getProductos() {
        return ((List<Producto>) productoDAO
                .findAll())
                .stream()
                .map(this::convertToProductoDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void updateProducto(int idproducto,ProductoDTO producto) {
        Producto prod = productoDAO.findById(idproducto).get();
        prod.setNombre(producto.getNombre());
        prod.setPrecio(producto.getPrecio());
        prod.setCantidad(producto.getCantidad());
        //Producto productodto = new ModelMapper().map(prod, Producto.class);

        productoDAO.save(prod);


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

    public Producto convertToProducto(ProductoDTO productoDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Producto producto=modelMapper.map(productoDTO, Producto.class);
        return producto;
    }
}