package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/clientes")
    @ResponseBody
    public void insertCliente(@RequestBody Cliente cliente) {
      clienteService.insertCliente(cliente);    }

}
