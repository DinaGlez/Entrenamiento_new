package com.example.entrenamiento.controller;

import com.example.entrenamiento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/test")
    public String test() {
        return "Greetings from Spring Boot by test!";
    }

}
