package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClienteController {

   @Autowired
    ClienteService clienteService;

    private static final Logger LOG = LogManager.getLogger("cliente");

    @GetMapping
    public ResponseEntity<Flux<ClienteDTO>> getAll() {
        Flux<ClienteDTO> response = clienteService.getAll();
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ClienteDTO>> getById(@PathVariable("id") String idcliente) {
        Mono<ClienteDTO> response = clienteService.getById(idcliente);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<ClienteDTO>> save(@RequestBody Mono<ClienteDTO> clienteDTO) {
        Mono<ClienteDTO> response = clienteService.save(clienteDTO);
        HttpStatus status = response != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ClienteDTO>> update(@RequestBody Mono<ClienteDTO> clienteDTO,@PathVariable String id) {
        Mono<ClienteDTO> response = clienteService.update(clienteDTO,id);
        HttpStatus status = response != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);
    }

}
