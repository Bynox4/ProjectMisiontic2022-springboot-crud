package com.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Services.ConfiguracionService;
import com.TO.Configuracion;

@Controller
public class ConfiguracionCtrl {
    
    @Autowired
    private ConfiguracionService configuracionService;

    @GetMapping("/configuracion")
    public String inicio(Model model){
        model.addAttribute("titulo", "Configuración");

        iniciar(model);

        return "Configuracion";
    }

    private void iniciar(Model model) {
        Configuracion configuracion = configuracionService.buscarConfiguracion();
        model.addAttribute("configuracion", configuracion);
    }

    // Guardar
    @PostMapping("/configuracion/guardar")
    public String guardar(Configuracion configuracion){
        configuracionService.guardar(configuracion);
        return "redirect:/configuracion";
    }

}
