package com.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Services.PlazasService;
import com.TO.Plazas;

@Controller
public class PlazasCtrl {
    
    @Autowired
    private PlazasService plazasService;

    @GetMapping("/plazas")
    public String inicio(Model model){
        model.addAttribute("titulo", "Plazas");

        iniciar(model); 

        return "Plazas";
    }

    private void iniciar(Model model) {
        if(model.getAttribute("plazas") == null){
            Plazas plaza = new Plazas();
            model.addAttribute("plaza", plaza);
        }

        var plazas = plazasService.listarplazas();
        model.addAttribute("plazas", plazas);
    }

    // Guardar
    @PostMapping("/plazas/guardar")
    public String guarda(Plazas plaza){
        plazasService.guardar(plaza);
        return "redirect:/plazas";
    }

    //  Editar 
    @GetMapping("/plazas/editar/{id_plazas}")
    public String editar(Plazas plaza, Model model){
        plaza = plazasService.buscarPlazas(plaza.getId_plazas());
        model.addAttribute("plaza", plaza);
        iniciar(model);
        return "Plazas";
    }

    // Boton - Eliminar
    @GetMapping("/plazas/eliminar/{id_plazas}")
    public String eliminar(Plazas plaza){
        plazasService.eliminar(plaza.getId_plazas());
        return "redirect:/plazas";
    }

    // @GetMapping("/plazas/estado/{id_plazas}")
    // public String estado(Plazas plaza){
    //     plazasService.;
    //     return "redirect:/plazas";
    // }

    // Listar 
    @GetMapping("/plazas/listar")
    public ResponseEntity<List<Plazas>> listar(){
        var plazas = plazasService.listarplazas();
        return new ResponseEntity<>(plazas, HttpStatus.OK);
    }

    // Eliminar
    @DeleteMapping("/plazas/eliminarPlz/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        Plazas obj = plazasService.buscarPlazas(id);
        if(obj != null){
            plazasService.eliminar(id);
            return new ResponseEntity<>("elemento eliminado", HttpStatus.OK);
        }else
            return new ResponseEntity<>("id no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
