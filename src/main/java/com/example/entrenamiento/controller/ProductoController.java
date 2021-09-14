package com.example.entrenamiento.controller;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {
@Autowired
ProductoService productoService;

    private static final Logger LOG = LogManager.getLogger(ProductoController.class);

    @GetMapping("/products")
    public List<Producto> getAll(){
        LOG.info("Get Greeting Message Input: ");

        return productoService.getProductos();
    }
    @PostMapping("/products")
    public void InsertProducto(Producto producto){
        productoService.insertProducto(producto);
    }
 @DeleteMapping("/products")
public  void DeleteProducto(int idproducto){
    productoService.deleteProducto(idproducto);
    }
}
