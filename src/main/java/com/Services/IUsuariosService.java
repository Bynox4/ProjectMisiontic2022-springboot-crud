package com.Services;

import java.util.List;
import com.TO.Usuarios;

public interface IUsuariosService {
    public Usuarios guardar(Usuarios usuario);

    public void eliminar(int id_usuarios);

    public List<Usuarios> listarusuarios();

    public Usuarios buscaUsuarios(int id_usuarios);
}
