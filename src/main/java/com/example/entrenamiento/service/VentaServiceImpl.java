package com.example.entrenamiento.service;


import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.DetalleVenta;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.*;
import com.example.entrenamiento.model.Venta;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaDAO ventaDAO;
    @Autowired
    ClienteService clienteService;
    @Autowired
    DetalleVentaService detalleVentaService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ProductoService productoService;


    @Override
    @Transactional
    public int insertVenta(VentaDTO ventaDTO) {
       Venta venta = convertToVenta(ventaDTO);

       Venta savedVenta= AddVenta(venta);
       //Obtengo la lista de DetalleVentaDTO que me da
       ArrayList<DetalleVentaDTO> detalles= ventaDTO.getProductos();

       detalles.stream().forEach(detalle->{

           Producto prod= productoService.getProductoById(detalle.getIdproducto());
           detalleVentaService.addDetalle(new DetalleVenta(null,detalle.getCantidad(),savedVenta,prod));
           prod.setCantidad(prod.getCantidad()-detalle.getCantidad());
           productoService.updateProducto(prod);


    });
                savedVenta.setImporte(ventaDTO.getProductos().stream().mapToDouble(detalle->{
                    Producto producto =productoService.getProductoById(detalle.getIdproducto());
                    return producto.getPrecio()*detalle.getCantidad();
                }).sum());
                ventaDAO.save(savedVenta);

                return savedVenta.getIdventa();
                  }

    public Venta AddVenta(Venta venta){
        Date date = new Date();
        venta.setFecha(date);
        return ventaDAO.save(venta);
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
    public List<DetalleVentaDTO> GetListaDetallleById(int idventa) {
        //return ((List<DetalleVentaDTO>) ventaDAO.findById(idventa).get().getDetalles().stream().map(detalleVentaService::convertToDetalleVentaDTO).collect(Collectors.toList())) ;
    return ventaDAO.findById(idventa).get().getDetalles().stream().map(detalleVentaService::convertToDetalleVentaDTO).collect(Collectors.toList());
    }

    @Override
    public VentaDTO getVenta(int idventa) {
        VentaDTO ventaDTO=modelMapper.map(ventaDAO.findById(idventa).get(),VentaDTO.class) ;
        ventaDTO.setProductos((ArrayList<DetalleVentaDTO>)GetListaDetallleById(idventa));

        return ventaDTO;
    }


    private VentaDTO convertToVentaDTO(Venta venta) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        VentaDTO ventaDTO=modelMapper.map(venta, VentaDTO.class);
      ventaDTO.setProductos((ArrayList<DetalleVentaDTO>) venta.getDetalles().stream().map(detalleVentaService::convertToDetalleVentaDTO).collect(Collectors.toList()));
        return ventaDTO;
    }
    private Venta convertToVenta(VentaDTO ventaDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Venta venta=modelMapper.map(ventaDTO, Venta.class);
       venta.setCliente(clienteService.getClienteById(ventaDTO.getIdcliente()));
        return venta;
    }

    }
