package com.example.entrenamiento.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {
    @Id
    private Integer idventa;
    private Date fecha;

    private double importe;

    @DBRef(lazy = false)
    private Cliente cliente;

    //@DBRef(lazy = false)
   // private List<DetalleVenta> detalles=new ArrayList<>();

    @Override
    public String toString() {
        return "Venta [Identificador=" + idventa + ", fecha=" + fecha + ", cliente="+cliente.getNombre() + cliente.getApellido()+"]";
    }

}
