package com.example.entrenamiento.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor // <--- THIS is it
@AllArgsConstructor
public class DetalleVenta {

    private Integer idDetalleVenta;

    private int cantidad;

    @DBRef(lazy = true)
    private Venta venta;


    //@DBRef(lazy = false)

    //private Producto Producto;

}
