package com.Ctrl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Services.FacturasService;
import com.Services.PlazasService;
import com.TO.Facturas;
import com.TO.Personas;
import com.TO.Plazas;


@Controller
public class FacturasCtrl {
    
    @Autowired
    private FacturasService facturasService;
    @Autowired
    private PlazasService plazasService;

    // _____________ METODOS ENTRADAS ______________

    // Inicio entradas
    @GetMapping("/entradas")
    public String entrada(Model model){
        model.addAttribute("titulo", "Entradas");

        iniciar(model);

        var facturas = facturasService.listarParqueados();
        model.addAttribute("facturas", facturas);
        
        return "Entradas";
    }

    // Listar Carros
    @GetMapping("/entradas/listarPlazasCarros")
    public String listarPlazasCarros(Model model){
        var plazas = plazasService.plazasLibrexTipo("carro");
        model.addAttribute("plazas", plazas);
        iniciar(model);
        return "Entradas";
    }

    // Listar Motos
    @GetMapping("/entradas/listarPlazasMotos")
    public String listarPlazasMoto(Model model){
        var plazas = plazasService.plazasLibrexTipo("moto");
        model.addAttribute("plazas", plazas);
        iniciar(model);
        return "Entradas";
    }

    // Guardar Entrada
    @PostMapping("/entradas/guardarEntrada")
    private String guardarEntrada(Facturas factura){
        Personas persona = new Personas();
        persona.setId_personas(1);;
        factura.setPersona(persona);
        Calendar calendar = Calendar.getInstance();
        factura.setFechaentrada(calendar.getTime());
        factura.setTipocontrato("normal");
        Plazas plaza = plazasService.buscarPlazas(factura.getPlaza().getId_plazas());
        plaza.setEstado("ocupada");
        facturasService.guardar(factura);
        return "redirect:/entradas";
    }   

    // _____________ METODOS SALIDAS ______________

    // INICIO SALIDAS
    @GetMapping("/salidas")
    public String salidas(Model model){
        model.addAttribute("titulo", "Salidas");

        iniciar(model);
        var facturas = facturasService.listarParqueados();
        model.addAttribute("facturas", facturas);
        
        return "Salidas";
    }

    // VER
    @GetMapping("/salidas/ver/{id_facturas}")
    public String ver(Facturas factura, Model model){
        factura = facturasService.buscarFacturas(factura.getId_facturas());
        factura = llenarVacios(factura);
        model.addAttribute("factura", factura);
        var facturas = facturasService.listarParqueados();
        model.addAttribute("facturas", facturas);
        return "Salidas";
    }

    // _____________ METODOS FACTURAS ______________


    // _____________ METODOS GENERALES ______________
    private void iniciar(Model model) {
        if(model.getAttribute("factura") == null){
            Facturas factura = new Facturas();
            model.addAttribute("factura", factura);
        }
    }

    // ________________________________________________

    // Inicio facturas
    @GetMapping("/facturas")
    public String inicio(Model model){
        model.addAttribute("titulo", "Facturas");

        iniciar(model);

        return "Facturas";
    }

    private Facturas llenarVacios(Facturas factura) {
        Calendar calendar = Calendar.getInstance();
        factura.setFechafactura(calendar.getTime());
        factura.setFechasalida(calendar.getTime());
        return factura;
    }
}