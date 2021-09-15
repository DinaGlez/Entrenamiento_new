package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/test")
    public void insertCliente( Cliente cliente) {
      clienteService.insertCliente(cliente);    }

}
