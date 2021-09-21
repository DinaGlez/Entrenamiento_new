package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.ClienteDAO;
import com.example.entrenamiento.repository.ClienteDAOImpl;
import com.example.entrenamiento.repository.VentaDAO;
import com.example.entrenamiento.model.Venta;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
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
    ClienteDAO clienteDAO;
    @Autowired
    private ModelMapper modelMapper;


 /*public VentaServiceImpl (ModelMapper modelMapper){
     this.modelMapper=modelMapper;
     this.modelMapper.addConverter(ConvertToVenta);

 }*/
    @Override
    public void insertVenta(VentaDTO ventaDTO) {
        Venta venta = convertToVenta(ventaDTO);
        ventaDAO.save(venta);
    }

    @Override
    public List<VentaDTO> getVentas() {
        return ((List<Venta>) ventaDAO
                .findAll())
                .stream()
                .map(this::convertToVentaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Venta GetVentaById(int idventa) {
       return ventaDAO.findById(idventa).get();
    }



    private VentaDTO convertToVentaDTO(Venta venta) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VentaDTO ventaDTO=modelMapper.map(venta, VentaDTO.class);
        return ventaDTO;
    }
    private Venta convertToVenta(VentaDTO ventaDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Venta venta=modelMapper.map(ventaDTO, Venta.class);
        venta.setCliente(clienteDAO.findById(ventaDTO.getIdcliente()).get());
        return venta;
    }
   /* Converter<VentaDTO, Venta> ConvertToVenta = new Converter<VentaDTO, Venta>() {
        @Override
        public Venta convert(MappingContext<VentaDTO, Venta> context) {
            //This custom converter replaces the one automatically created by ModelMapper,
            //So we have to map each of the contact fields as well.
            context.getDestination().setIdventa(context.getSource().getIdventa());
            context.getDestination().setFecha(context.getSource().getFecha());
            context.getDestination().setCliente(new ClienteServicioImpl().getClienteById2(context.getSource().getIdcliente()));


            return context.getDestination();
        }

    };*/
    }
