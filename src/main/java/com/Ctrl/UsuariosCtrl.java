package com.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Services.PersonasService;
import com.Services.UsuariosService;
import com.TO.Usuarios;

@Controller
public class UsuariosCtrl {

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private PersonasService personasService;

    // Inicio
    @GetMapping("/usuarios")
    public String inicio(Model model){
        model.addAttribute("titulo", "Usuarios");

        iniciar(model);

        return "Usuarios";
    }
    
    private void iniciar(Model model) {
        if(model.getAttribute("usuario") == null){
            Usuarios usuario = new Usuarios();
            model.addAttribute("usuario", usuario);
        }
        var usuarios = usuariosService.listarusuarios();
        model.addAttribute("usuarios", usuarios);
        
        var personas = personasService.listarpersonas();
        model.addAttribute("personas", personas);
    }

    // Guardar
    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuarios usuario){
        usuariosService.guardar(usuario);
        return "redirect:/usuarios";
    }
    //Editar
    @GetMapping("/usuarios/editar/{id_usuarios}")
    public String editarUsuario(Usuarios usuario, Model model){
        usuario = usuariosService.buscaUsuarios(usuario.getId_usuarios());
        model.addAttribute("usuario", usuario);
        iniciar(model);
        return "Usuarios";
    }
    // Boton - Eliminar
    @GetMapping("/usuarios/eliminar/{id_usuarios}")
    public String eliminar(Usuarios usuario){
        usuariosService.eliminar(usuario.getId_usuarios());
        return "redirect:/usuarios";
    }

    // Listar
    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<Usuarios>> listar(){
        var usuarios = usuariosService.listarusuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Eliminar
    @DeleteMapping("/usuarios/eliminarUsr/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        Usuarios obj = usuariosService.buscaUsuarios(id);
        if(obj != null){
            usuariosService.eliminar(id);
            return new ResponseEntity<>("elemento eliminado", HttpStatus.OK);
        }else
            return new ResponseEntity<>("id no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
