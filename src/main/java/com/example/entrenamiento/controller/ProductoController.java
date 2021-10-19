package com.example.entrenamiento.controller;

import com.example.entrenamiento.apierror.EntityNotFoundException;
import com.example.entrenamiento.model.Producto;import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController
@RequestMapping("/api/products")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Flux<Producto>> getAll() {
        Flux<Producto> response = productoService.getAll();
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Producto>> getById(@PathVariable("id") int idproducto) {
        Mono<Producto> response = productoService.getById(idproducto);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<Producto>> save(@RequestBody Producto cliente) {
        Mono<Producto> response = productoService.save(cliente);
        HttpStatus status = response != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Producto>> update(@RequestBody Producto producto) {
        Mono<Producto> response = productoService.update(producto);
        HttpStatus status = response != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);
    }

}
