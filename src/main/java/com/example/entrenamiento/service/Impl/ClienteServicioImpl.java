package com.example.entrenamiento.service.Impl;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.repository.ClienteDAO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.service.ClienteService;
import com.example.entrenamiento.utils.AppUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.sql.DataSource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class ClienteServicioImpl implements ClienteService {
    @Autowired
    ClienteDAO clienteDAO;


    @Override
    public Flux<ClienteDTO> getAll() {
        return clienteDAO.findAll().map(AppUtils::entityToDTO);
    }

    @Override
    public Mono<ClienteDTO> getById(String idproducto) {

        return clienteDAO.findById(idproducto).map(AppUtils::entityToDTO);
    }

    @Override
    public Mono<ClienteDTO> save(Mono<ClienteDTO> productoDTO) {
        return productoDTO.map(AppUtils::DTOtoEntity)
                .flatMap(clienteDAO::save)
                .map(AppUtils::entityToDTO);

    }

    @Override
    public Mono<ClienteDTO> update(Mono<ClienteDTO> productoDTO, String id) {
        return clienteDAO.findById(id).flatMap(p -> productoDTO.map(AppUtils::DTOtoEntity))
                .doOnNext(e -> e.setIdcliente(id))
                .flatMap(clienteDAO::save)
                .map(AppUtils::entityToDTO);
    }

}