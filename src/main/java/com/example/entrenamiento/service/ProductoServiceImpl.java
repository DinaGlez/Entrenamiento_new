package com.example.entrenamiento.service;



import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoDAO productoDAO;
 /*   @Autowired
    private ModelMapper modelMapper;
*/
    @Override
    public void AddProducto(ProductoDTO productoDTO) {
        Producto producto = new ModelMapper().map(productoDTO, Producto.class);
        productoDAO.save(producto).subscribe();

    }


    @Override
    public Mono<Void> deleteProducto(int idproducto) {

           return  productoDAO.deleteById(idproducto);


    }


    @Override
    public Mono<Producto> getProductoById(int idproducto) {

        return productoDAO.findById(idproducto);
    }
    @Override
        public Flux<Producto> getProductos() {
        return productoDAO.findAll();
    }

    @Override
    public Mono<Producto> updateProducto(Producto producto) {
        return productoDAO.save(producto);
    }
    /*@Override
    public void updateProducto(int idproducto,ProductoDTO producto) {
        Producto prod = productoDAO.findById(idproducto).get();
        prod.setNombre(producto.getNombre());
        prod.setPrecio(producto.getPrecio());
        prod.setCantidad(producto.getCantidad());
        //Producto productodto = new ModelMapper().map(prod, Producto.class);

        productoDAO.save(prod);


    }*/




   /* private ProductoDTO convertToProductoDTO(Producto producto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ProductoDTO productoDTO=modelMapper.map(producto,ProductoDTO.class);
        return productoDTO;
    }

    public Producto convertToProducto(ProductoDTO productoDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Producto producto=modelMapper.map(productoDTO, Producto.class);
        return producto;
    }*/

/* @Override
    public Mono<ProductoDTO> getProductoDTOById(int idproducto) {
        return  convertToProductoDTO(productoDAO.findById(idproducto));
    }*/
}