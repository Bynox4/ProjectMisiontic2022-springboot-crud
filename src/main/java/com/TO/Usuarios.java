package com.TO;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_usuarios;
    private String usuario;
    private String clave;
    private String rol;
    // private int id_personas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_personas")
    private Personas persona;
}
