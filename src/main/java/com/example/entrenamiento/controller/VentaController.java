package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.service.DetalleVentaService;
import com.example.entrenamiento.service.VentaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    private static final Logger LOGGER = LogManager.getLogger(VentaController.class);

    @Autowired
    VentaService ventaService;
    @Autowired
    DetalleVentaService detalleVentaService;

    @GetMapping("/ventas")
    public List<VentaDTO> getAll(){

        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{idventa}")
    public VentaDTO getVenta(@PathVariable ("idventa")int idventa){

        return ventaService.getVenta(idventa);
    }

    @PostMapping("/ventas")
    public ResponseEntity<?> InsertVenta(@RequestBody VentaDTO venta){
       int id= ventaService.insertVenta(venta);
        return ResponseEntity.ok(ventaService.getVenta(id));
    }



}
