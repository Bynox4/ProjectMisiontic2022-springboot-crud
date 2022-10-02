package com.Services;

import java.util.List;
import com.TO.Plazas;

public interface IPlazasService {
    public Plazas guardar(Plazas plaza);

    public void eliminar(int plaza);

    public List<Plazas> listarplazas();

    public Plazas buscarPlazas(int plaza);

    public List<Plazas> plazasLibrexTipo(String tipo);

}
