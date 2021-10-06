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
import java.util.Locale;

@RestController
public class ProductoController {
@Autowired
ProductoService productoService;

    private static final Logger LOG = LogManager.getLogger("producto");
    @GetMapping("/")
    public String Starting(){

        return "Just starting";
    }
    @GetMapping("/products")
    public List<ProductoDTO> getAll() throws EntityNotFoundException {
       LOG.info("Consultar listado de productos");
        return productoService.getProductos();
    }
    @GetMapping("/products/{idproducto}")
    public ProductoDTO getProductById(@PathVariable ("idproducto")int idproducto) throws EntityNotFoundException{
         ProductoDTO prod=productoService.getProductoDTOById(idproducto);
       LOG.info("Consultar detalles del producto"+ prod.toString().toUpperCase(Locale.ROOT));
        return prod ;    }
    @PutMapping("/products/{idproducto}")
    public ResponseEntity<?> updateProducto(@PathVariable ("idproducto") int idproducto, @RequestBody ProductoDTO productodto){
        productoService.updateProducto(idproducto, productodto);
        LOG.info("Actualizar producto: " + productodto.getNombre() + productodto.toString());
         return ResponseEntity.ok(productoService.getProductoDTOById(idproducto));
    }
    @PostMapping("/products")
    public ResponseEntity<?> AddProducto(@RequestBody ProductoDTO producto){

        productoService.AddProducto(producto);
        LOG.info("Insercion del producto:"+ producto.getNombre());
        return ResponseEntity.ok(producto);
    }

   @DeleteMapping("/products/{idproducto}")
   public ResponseEntity<Producto> DeleteProducto(@PathVariable ("idproducto") int idproducto) throws Exception{
    try {
        productoService.deleteProducto(idproducto);

    }catch (Exception e){
        throw new Exception("Imposibe borrar producto, esta asociado a ventas");
    }
    LOG.info("Intento de eliminar producto:"+ productoService.getProductoById(idproducto).toString());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
