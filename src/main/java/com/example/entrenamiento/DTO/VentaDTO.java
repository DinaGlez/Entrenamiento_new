package com.example.entrenamiento.DTO;

import com.example.entrenamiento.model.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VentaDTO {

    private String nombreCliente;
    private String apellidoCliente;
    private Date fecha;


}
