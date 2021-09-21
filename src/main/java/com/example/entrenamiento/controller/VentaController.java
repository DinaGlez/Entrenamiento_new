package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.DetalleVenta;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.service.DetalleVentaService;
import com.example.entrenamiento.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;
    @Autowired
    DetalleVentaService detalleVentaService;

    @GetMapping("/ventas")
    public List<VentaDTO> getAll(){

        return ventaService.getVentas();
    }
    @PostMapping("/ventas")
    public void InsertVenta(@RequestBody VentaDTO venta){
        ventaService.insertVenta(venta);
    }

    @PostMapping("/AddProduct/{idventa}/{idproducto}")
    public void InsertProducto(@RequestBody @PathVariable ("idventa")int idventa,@PathVariable ("idproducto")int idproducto){
        Venta venta=ventaService.GetVentaById(idventa);

        detalleVentaService.addProducto(venta,idproducto);
    }

}
