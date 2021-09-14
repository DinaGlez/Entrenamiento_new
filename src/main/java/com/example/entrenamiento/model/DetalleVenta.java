package com.example.entrenamiento.model;

import javax.persistence.*;
import java.util.Date;
@Entity

public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer inDetalleVenta;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

}
