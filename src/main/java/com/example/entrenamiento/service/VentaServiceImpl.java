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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VentaServiceImpl /*implements VentaService*/ {
    /*@Autowired
    VentaDAO ventaDAO;
    @Autowired
    ClienteService clienteService;
    @Autowired
    DetalleVentaService detalleVentaService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ProductoService productoService;


    //@Override
   // @Transactional
  /*  public int insertVenta(VentaDTO ventaDTO) {
        Date date = new Date();
        Venta venta = Venta.builder()
                .fecha(date)
                .cliente(clienteService.getClienteById(ventaDTO.getIdcliente()))
                .build();
        ventaDAO.save(venta);


        ArrayList<DetalleVenta> detalles= new ArrayList<>();
        detalles= (ArrayList<DetalleVenta>) ventaDTO.getProductos()
                .stream()
                .map(detalle->{
                     Producto prod =productoService.getProductoById(detalle.getIdproducto());
                     int cant=(prod.getCantidad()-detalle.getCantidad())>0? (prod.getCantidad()-detalle.getCantidad()): 0  ;
                    //test
                    prod.setCantidad(cant==0? prod.getCantidad() : cant);
                       return new DetalleVenta(null, cant!=0?detalle.getCantidad():0, venta, prod);


                })
                .collect(Collectors.toList());




    venta.setDetalles(detalles);
    venta.setImporte(calcImporte(detalles));

     return venta.getIdventa();
    }
    public double calcImporte(ArrayList<DetalleVenta> detalles){
      double importe=  detalles.stream().mapToDouble(detalle->{
            return detalle.getProducto().getPrecio()*detalle.getCantidad();
        }).sum();
       return importe;
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

*/
}
