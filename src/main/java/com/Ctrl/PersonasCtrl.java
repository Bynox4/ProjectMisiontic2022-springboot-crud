package com.Ctrl;

// import javax.persistence.PostRemove;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Services.PersonasService;
import com.TO.Personas;

@Controller
public class PersonasCtrl {
    
    @Autowired
    private PersonasService personasService;

    // METODOS PARA LA PAGINA HTML
    // Inicio
    @GetMapping("/personas")
    public String inicio(Model model){
        model.addAttribute("titulo", "Personas");

        iniciar(model);

        return "Personas";
    }

    private void iniciar(Model model) {
        if(model.getAttribute("persona") == null){
            Personas persona = new Personas();
            model.addAttribute("persona", persona);
        }
        var personas = personasService.listarpersonas();
        model.addAttribute("personas", personas);
    }

    // Guardar
    @PostMapping("/personas/guardar")
    public String guardar(Personas persona){
        personasService.guardar(persona);
        return "redirect:/personas";
    }

    //Editar
    @GetMapping("/personas/editar/{id_personas}")
    public String editar(Personas persona, Model model){
        persona = personasService.buscaPersonas(persona.getId_personas());
        model.addAttribute("persona", persona);
        iniciar(model);
        return "Personas";
    }

    // Boton - Eliminar
    @GetMapping("/personas/eliminar/{id_personas}")
    public String eliminar(Personas persona){
        personasService.eliminar(persona.getId_personas());
        return "redirect:/personas";
    }

    // METODOS PARA Post
    // Listar
    @GetMapping("/personas/listar")
    public ResponseEntity<List<Personas>> listar(){
        var personas = personasService.listarpersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
    // Eliminar
    @DeleteMapping("/personas/eliminarPrs/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        Personas obj = personasService.buscaPersonas(id);
        if(obj != null){
            personasService.eliminar(id);
            return new ResponseEntity<>("elemento eliminado", HttpStatus.OK);
        }else
        return new ResponseEntity<>("id no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // @PostMapping("/personas/registrar")
    // public ResponseEntity<Personas> registrar(@RequestBody Personas personas){
    //     return new ResponseEntity<>(personasService.guardar(personas), HttpStatus.OK);
    // }
}
