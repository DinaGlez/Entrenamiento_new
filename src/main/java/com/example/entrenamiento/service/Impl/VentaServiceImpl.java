package com.example.entrenamiento.service.Impl;


import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.repository.*;
import com.example.entrenamiento.service.VentaService;
import com.example.entrenamiento.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class VentaServiceImpl implements VentaService{
    @Autowired
    VentaDAO ventaDAO;

    @Override
    public Flux<VentaDTO> getAll() {
        return ventaDAO.findAll().map(AppUtils::entityToDTO);
    }

    @Override
        public Mono<VentaDTO> getById(int idventa) {

             return ventaDAO.findById(idventa).map(AppUtils::entityToDTO);
          }

        @Override
        public Mono<VentaDTO> save(Mono<VentaDTO> productoDTO) {
            return productoDTO.map(AppUtils::DTOtoEntity)
                    .flatMap(ventaDAO::save)
                    .map(AppUtils::entityToDTO);

        }

        @Override
        public Mono<VentaDTO> update(Mono<VentaDTO> ventaDTOMono,int id ) {
            return ventaDAO.findById(id).flatMap(p->ventaDTOMono.map(AppUtils::DTOtoEntity))
                    .doOnNext(e -> e.setIdventa(id))
                    .flatMap(ventaDAO::save)
                    .map(AppUtils::entityToDTO);
        }

}
