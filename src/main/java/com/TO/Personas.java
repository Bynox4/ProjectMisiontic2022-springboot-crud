package com.TO;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="personas")
public class Personas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personas;
    private String nombres;
    private String apellidos;
    private String tipodoc;
    private String numdoc;
    private String direccion;
    private String telefono;
    private String email;
}
