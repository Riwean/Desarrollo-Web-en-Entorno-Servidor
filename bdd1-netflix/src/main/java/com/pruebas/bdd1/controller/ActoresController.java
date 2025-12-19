package com.pruebas.bdd1.controller;

import com.pruebas.bdd1.model.Actores;
import com.pruebas.bdd1.services.ActoresService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ActoresController {

    private final ActoresService actoresService;

    public ActoresController(ActoresService actoresService) {
        this.actoresService = actoresService;
    }

    @GetMapping("/actores")
    public String listarActores(Model model) {
        List<Actores> lista = actoresService.findAll();
        model.addAttribute("actores", lista);
        return "actores";
    }

    @GetMapping("/actores/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Actores actor = actoresService.findById(id);
        model.addAttribute("actor", actor);
        return "actor-editar";
    }

    @PostMapping("/actores/editar")
    public String guardarEdicion(@ModelAttribute("actor") Actores actor) {
        actoresService.save(actor);
        return "redirect:/actores";
    }
}
