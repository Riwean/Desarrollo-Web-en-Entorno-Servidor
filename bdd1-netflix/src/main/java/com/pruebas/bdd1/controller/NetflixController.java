package com.pruebas.bdd1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NetflixController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "Bienvenido a NetflixDB");
        // Podrías usar estos textos u opciones en la vista
        model.addAttribute("opcionSeries", "Listar series");
        model.addAttribute("opcionActores", "Listar actores");
        model.addAttribute("opcionEpisodios", "Listar episodios");
        return "inicio"; // nombre de la plantilla inicio.html
    }
}
