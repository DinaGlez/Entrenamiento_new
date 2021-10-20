package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.service.ProductoService;
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
    public ResponseEntity<Flux<ProductoDTO>> getAll() {
        Flux<ProductoDTO> response = productoService.getAll();
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ProductoDTO>> getById(@PathVariable("id") String idproducto) {
        Mono<ProductoDTO> response = productoService.getById(idproducto);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response,status);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<ProductoDTO>> save(@RequestBody Mono<ProductoDTO> productoDTO) {
        Mono<ProductoDTO> response = productoService.save(productoDTO);
        HttpStatus status = response != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ProductoDTO>> update(@RequestBody Mono<ProductoDTO> productoDTO,@PathVariable String id) {
        Mono<ProductoDTO> response = productoService.update(productoDTO,id);
        HttpStatus status = response != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response,status);
    }

}
