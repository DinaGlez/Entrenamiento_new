package com.example.entrenamiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it

public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer inVenta;

    private Date fecha;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

    @Override
    public String toString() {
        return "Venta [Identificador=" + inVenta + ", fecha=" + fecha + ", cliente="+cliente.getNombre() + cliente.getApellido()+"]";
    }

}
