package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.DetalleVentaDTO;
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
    @GetMapping("/ventaDetalle/{idventa}")
    public List<DetalleVentaDTO> getVentaById(@PathVariable ("idventa")int idventa){

        return ventaService.GetListaDetallleById(idventa);
    }
    @GetMapping("/venta/{idventa}")
    public VentaDTO getVenta(@PathVariable ("idventa")int idventa){

        return ventaService.getVenta(idventa);
    }

    @PostMapping("/ventas")
    public void InsertVenta(@RequestBody VentaDTO venta){
        ventaService.insertVenta(venta);
    }



}
