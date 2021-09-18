package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @ResponseBody
    @GetMapping("/clientes")
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();    }


    @PostMapping("/clientes")
    public void insertCliente(@RequestBody ClienteDTO cliente) {
      clienteService.AddCliente(cliente);    }

}
