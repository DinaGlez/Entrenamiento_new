package com.example.entrenamiento.controller;

import com.example.entrenamiento.apierror.EntityNotFoundException;
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
    public List<ProductoDTO> getAll() throws EntityNotFoundException {

        return productoService.getProductos();
    }
    @GetMapping("/products/{idproducto}")
    public ProductoDTO getProductById(@PathVariable ("idproducto")int idproducto) throws EntityNotFoundException{

        return productoService.getProductoDTOById(idproducto);
    }
    @PutMapping("/products/{idproducto}")
    public ResponseEntity<?> updateProducto(@PathVariable ("idproducto") int idproducto, @RequestBody ProductoDTO productodto){
        productoService.updateProducto(idproducto, productodto);
         return ResponseEntity.ok(productoService.getProductoDTOById(idproducto));
    }
    @PostMapping("/products")
    public ResponseEntity<?> AddProducto(@RequestBody ProductoDTO producto){

        productoService.AddProducto(producto);
        return ResponseEntity.ok(producto);
    }

   @DeleteMapping("/products/{idproducto}")
   public ResponseEntity<Producto> DeleteProducto(@PathVariable ("idproducto") int idproducto){
    productoService.deleteProducto(idproducto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
