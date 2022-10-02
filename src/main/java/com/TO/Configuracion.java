package com.TO;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="configuracion")
public class Configuracion implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_configuracion;
    private String nombreparqueadero;
    private Double valorhoracarro;
    private Double valorhoramoto;
    private Double valorfraccarro;
    private Double valorfracmoto;
    private Double valordiacarro;
    private Double valordiamoto;
    private Double valorsemcarro;
    private Double valorsemmoto;
    private Double valormescarro;
    private Double valormesmoto;
}
