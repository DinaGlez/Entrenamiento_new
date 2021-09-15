package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;


    @GetMapping("/ventas")
    public List<Venta> getAll(){

        return ventaService.GetVentas();
    }
    @PostMapping("/ventas/")
    public void InsertProducto(Venta venta){
        ventaService.insertVenta(venta);
    }

}
