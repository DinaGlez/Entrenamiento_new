package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.VentaDAO;
import com.example.entrenamiento.model.Venta;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VentaServiceImpl implements VentaService {
 @Autowired
 VentaDAO ventaDAO;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void insertVenta(Venta ventaDto) {
       // Venta venta = new ModelMapper().map(ventaDto, Venta.class);
        ventaDAO.save(ventaDto);
    }



    @Override
      public List<VentaDTO> getVentas() {
        return ((List<Venta>) ventaDAO
                .findAll())
                .stream()
                .map(this::convertToVentaDTO)
                .collect(Collectors.toList());
    }


    private VentaDTO convertToVentaDTO(Venta venta) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VentaDTO ventaDTO=modelMapper.map(venta, VentaDTO.class);
        return ventaDTO;
    }
}
