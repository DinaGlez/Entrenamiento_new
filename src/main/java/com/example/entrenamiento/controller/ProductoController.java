package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
@Autowired
ProductoService productoService;

    private static final Logger LOG = LogManager.getLogger(ProductoController.class);
    @GetMapping("/")
    public String Starting(){

        return "Just starting";
    }
    @GetMapping("/products")
    public List<ProductoDTO> getAll(){

        return productoService.getProductos();
    }
    @GetMapping("/products/{idproducto}")
    public ProductoDTO getProductById(@PathVariable ("idproducto")int idproducto){

        return productoService.getProductoById(idproducto);
    }
    @PutMapping("/products/{idproducto}")
    public void updateProducto(@PathVariable ("idproducto") int idproducto, @RequestBody ProductoDTO productodto){
        productoService.updateProducto(idproducto, productodto);

    }
    @PostMapping("/products")
    public void AddProducto(@RequestBody ProductoDTO producto){
         productoService.AddProducto(producto);
    }

   @DeleteMapping("/products/{idproducto}")
   public ResponseEntity<Producto> DeleteProducto(@PathVariable ("idproducto") int idproducto){
    productoService.deleteProducto(idproducto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
