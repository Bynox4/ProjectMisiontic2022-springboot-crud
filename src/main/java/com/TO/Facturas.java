package com.TO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="facturas")
public class Facturas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_facturas;
    private String placa; 
    private String tipocontrato;
    private Date fechaentrada;
    private Date fechasalida;
    private Double valor;
    private Date fechafactura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_plaza")
    private Plazas plaza;
    // private int id_plaza;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_personas")
    private Personas persona;
    // private int id_personas;
    private String codigofactura;
}

