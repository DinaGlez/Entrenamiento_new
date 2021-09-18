package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
@Autowired
ProductoService productoService;

    private static final Logger LOG = LogManager.getLogger(ProductoController.class);

    @GetMapping("/products")
    public List<ProductoDTO> getAll(){

        return productoService.getProductos();
    }
    @PostMapping("/products")
    public void AddProducto(@RequestBody ProductoDTO producto){
         productoService.AddProducto(producto);
    }

   @DeleteMapping("/products/{idproducto}")
   public  void DeleteProducto(@PathVariable int idproducto){
    productoService.deleteProducto(idproducto);
    }
}
