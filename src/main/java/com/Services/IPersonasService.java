package com.Services;

import java.util.List;
import com.TO.Personas;

public interface IPersonasService {
    public Personas guardar(Personas persona);

    public void eliminar(int id_personas);

    public List<Personas> listarpersonas();

    public Personas buscaPersonas(int id_personas);
}
