package com.example.entrenamiento.service;

import com.example.entrenamiento.model.DetalleVenta;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.repository.DetalleVentaDAO;
import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.repository.ProductoDaoImpl;
import com.example.entrenamiento.repository.VentaDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServicioImpl implements DetalleVentaService{

    @Autowired
    DetalleVentaDAO detalleVentaDAO;

    @Autowired
     ProductoDAO productoDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addProducto(Venta venta, int idproducto) {
        Producto prod=productoDAO.findById(idproducto).get();

        DetalleVenta detalleVenta = DetalleVenta.builder()
                .Producto(prod)
                //.idproducto(10)
                .venta(venta)
                .build();


        detalleVentaDAO.save(detalleVenta);
    }
}
