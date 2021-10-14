package com.example.entrenamiento.controller;

import com.example.entrenamiento.apierror.EntityNotFoundException;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
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

import java.util.List;
import java.util.Locale;

@RestController
//@RequestMapping("/api/products")
public class ProductoController {
@Autowired
ProductoService productoService;

    private static final Logger LOG = LogManager.getLogger("producto");

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Producto> getAll() throws EntityNotFoundException {
       LOG.info("Consultar listado de productos");
        return productoService.getProductos();
    }
    @GetMapping("products/{idproducto}")
    public ResponseEntity<Mono<Producto>> getProductById(@PathVariable ("idproducto")int idproducto) throws EntityNotFoundException{
         Mono<Producto> prod=productoService.getProductoById(idproducto);
       LOG.info("Consultar detalles del producto"+ prod.toString().toUpperCase(Locale.ROOT));
        return new ResponseEntity<Mono<Producto>>(prod,prod!=null?HttpStatus.OK:HttpStatus.NOT_FOUND) ;    }
    @PutMapping("products/{idproducto}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Producto> updateProducto( @RequestBody Producto producto){

        LOG.info("Actualizar producto: " + producto.getNombre() + producto.toString());
         return productoService.updateProducto(producto);
    }
    @PostMapping("products/")
    public void AddProducto(@RequestBody ProductoDTO producto){
        LOG.info("Insercion del producto:"+ producto.getNombre());
        productoService.AddProducto(producto);
    }

   @DeleteMapping("products/{idproducto}")
   @ResponseStatus(HttpStatus.OK)
   public void DeleteProducto(@PathVariable ("idproducto") int idproducto){
       LOG.info("Intento de eliminar producto:"+ productoService.getProductoById(idproducto).toString());
       productoService.deleteProducto(idproducto).subscribe();
    }
}
