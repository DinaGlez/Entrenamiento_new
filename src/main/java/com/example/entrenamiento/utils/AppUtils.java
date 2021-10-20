package com.example.entrenamiento.utils;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.DTO.VentaDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ProductoDTO entityToDTO (Producto producto){
        ProductoDTO productoDTO= new ProductoDTO();
        BeanUtils.copyProperties(producto,productoDTO);
        return productoDTO;
    }

    public static Producto DTOtoEntity (ProductoDTO productoDTO){
        Producto producto= new Producto();
        BeanUtils.copyProperties(productoDTO,producto);
        return producto;
    }

    public static ClienteDTO entityToDTO (Cliente cliente){
        ClienteDTO clienteDTO= new ClienteDTO();
        BeanUtils.copyProperties(cliente,clienteDTO);
        return clienteDTO;
    }

    public static Cliente DTOtoEntity (ClienteDTO clienteDTO){
        Cliente cliente= new Cliente();
        BeanUtils.copyProperties(clienteDTO,cliente);
        return cliente;
    }
    public static VentaDTO entityToDTO (Venta venta){
        VentaDTO ventaDTO= new VentaDTO();
        BeanUtils.copyProperties(venta,ventaDTO);
        return ventaDTO;
    }

    public static Venta DTOtoEntity (VentaDTO ventaDTO){
        Venta venta= new Venta();
        BeanUtils.copyProperties(ventaDTO,venta);
        return venta;
    }
}
