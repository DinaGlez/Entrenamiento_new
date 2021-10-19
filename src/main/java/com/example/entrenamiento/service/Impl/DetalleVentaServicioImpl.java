package com.example.entrenamiento.service.Impl;

import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServicioImpl /*implements DetalleVentaService*/{

  /*  @Autowired
    DetalleVentaDAO detalleVentaDAO;
    @Autowired
    VentaService ventaService;

    @Autowired
     ProductoDAO productoDAO;

    @Autowired
    private ModelMapper modelMapper;


   /* public void addProducto(Venta venta, int idproducto) {
        Producto prod=productoDAO.findById(idproducto).get();

        DetalleVenta detalleVenta = DetalleVenta.builder()
                .Producto(prod)
                //.idproducto(10)
                .venta(venta)
                .build();


        detalleVentaDAO.save(detalleVenta);
    }

    @Override
    public void insertDetalle(DetalleVenta detalleVenta) {
        detalleVentaDAO.save(detalleVenta);
    }

    @Override
    public DetalleVenta addDetalle(DetalleVenta detalleVenta) {
        return detalleVentaDAO.save(detalleVenta);

    }

    @Override
    public List<DetalleVentaDTO> getDetalles(int idventa) {
        return detalleVentaDAO.findDetalleVentaByVenta(idventa);
    }
    /*public DetalleVenta convertToDetalleVenta(DetalleVentaDTO detalleVentaDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DetalleVenta detalleVenta=modelMapper.map(detalleVentaDTO, DetalleVenta.class);

        return detalleVenta;
    }
    public DetalleVentaDTO convertToDetalleVentaDTO(DetalleVenta detalleVenta) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DetalleVentaDTO detalleVentaDTO=modelMapper.map(detalleVenta, DetalleVentaDTO.class);

        return detalleVentaDTO;
    }

    @Override
    public DetalleVenta convertToDetalleVenta(DetalleVentaDTO detalleVentaDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DetalleVenta detalleVenta=modelMapper.map(detalleVentaDTO, DetalleVenta.class);

        return detalleVenta;
    }
*/
}
