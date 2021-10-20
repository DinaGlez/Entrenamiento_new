package com.example.entrenamiento.service.Impl;



import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.DTO.ProductoDTO;


import com.example.entrenamiento.service.ProductoService;
import com.example.entrenamiento.utils.AppUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoDAO productoDAO;

 @Override
 public Flux<ProductoDTO> getAll() {
     return productoDAO.findAll().map(AppUtils::entityToDTO);
 }

    @Override
    public Mono<ProductoDTO> getById(String idproducto) {

     return productoDAO.findById(idproducto).map(AppUtils::entityToDTO);
    }

    @Override
    public Mono<ProductoDTO> save(Mono<ProductoDTO> productoDTO) {
        return productoDTO.map(AppUtils::DTOtoEntity)
            .flatMap(productoDAO::save)
             .map(AppUtils::entityToDTO);

    }

    @Override
    public Mono<ProductoDTO> update(Mono<ProductoDTO> productoDTO,String id ) {
        return productoDAO.findById(id).flatMap(p->productoDTO.map(AppUtils::DTOtoEntity))
                .doOnNext(e -> e.setIdproducto(id))
                .flatMap(productoDAO::save)
                .map(AppUtils::entityToDTO);
    }

}