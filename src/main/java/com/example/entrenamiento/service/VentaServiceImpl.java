package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ProductoVentaDTO;
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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaDAO ventaDAO;
    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    ProductoDAO productoDAO;
    @Autowired
    DetalleVentaDAO detalleVentaDAO;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public void insertVenta(VentaDTO ventaDTO) {
       Venta venta = convertToVenta(ventaDTO);
        //Venta venta=modelMapper.map(ventaDTO, Venta.class);
       Venta savedVenta= AddVenta(venta);
       ArrayList<ProductoVentaDTO> productos= ventaDTO.getProductos();
       productos.forEach((ProductoVentaDTO producto)->{
 Producto prod= productoDAO.findById(producto.getIdproducto()).get();
            detalleVentaDAO.save(new DetalleVenta(null,producto.getCantidad(),savedVenta,prod));
           Producto productoUpdated= productoDAO.findById(producto.getIdproducto()).get();
           productoUpdated.setCantidad(productoUpdated.getCantidad()-producto.getCantidad());
            productoDAO.save(productoUpdated);
            float importe=savedVenta.getImporte();
            importe = importe+producto.getCantidad()*productoUpdated.getPrecio();
             savedVenta.setImporte(importe);
    });

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
