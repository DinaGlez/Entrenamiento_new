package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.VentaDAO;
import com.example.entrenamiento.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class VentaServiceImpl implements VentaService {
 @Autowired
 VentaDAO ventaDAO;
    @Override
    public void insertVenta(Venta venta) {
        ventaDAO.insertVenta(venta);
    }

    @Override
    public List<Venta> GetVentas() {
        List<Venta> ventas=new ArrayList<>();
        ventaDAO.getVentas().forEach(ventas::add);
        return null;
    }
}
