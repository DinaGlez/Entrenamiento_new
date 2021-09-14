package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {

    @Autowired
    VentaService ventaService;
}
