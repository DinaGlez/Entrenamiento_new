package com.example.entrenamiento.service;
import com.example.entrenamiento.service.ProductoService;

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

import java.util.ArrayList;
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
    public void insertVenta(VentaDTO ventaDTO) {
       Venta venta = convertToVenta(ventaDTO);

       Venta savedVenta= AddVenta(venta);
       //Obtengo la lista de DetalleVentaDTO que me da
       ArrayList<DetalleVentaDTO> productos= ventaDTO.getProductos();

       productos.forEach((DetalleVentaDTO producto)->{

           Producto prod= productoService.getProductoById(producto.getIdproducto());
            detalleVentaService.insertDetalle(new DetalleVenta(null,producto.getCantidad(),savedVenta,prod));
           Producto productoUpdated= productoService.getProductoById(producto.getIdproducto());
           productoUpdated.setCantidad(productoUpdated.getCantidad()-producto.getCantidad());
           productoService.updateProducto(productoUpdated);

    });
                savedVenta.setImporte(ventaDTO.getProductos().stream().mapToDouble(detalle->{
                    Producto producto =productoService.getProductoById(detalle.getIdproducto());
                    return producto.getPrecio()*detalle.getCantidad();
                }).sum());
                ventaDAO.save(savedVenta);
    }

    public Venta AddVenta(Venta venta){
        venta.setImporte(0);
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
       venta.setCliente(clienteService.getClienteById(ventaDTO.getIdcliente()));
        return venta;
    }

    }
