package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idventa;
    @NotNull
    private Date fecha;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

    @Override
    public String toString() {
        return "Venta [Identificador=" + idventa + ", fecha=" + fecha + ", cliente="+cliente.getNombre() + cliente.getApellido()+"]";
    }

}
