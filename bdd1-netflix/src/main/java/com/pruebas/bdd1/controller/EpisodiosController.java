package com.pruebas.bdd1.controller;

import com.pruebas.bdd1.model.Episodios;
import com.pruebas.bdd1.services.EpisodiosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EpisodiosController {

    private final EpisodiosService episodiosService;

    public EpisodiosController(EpisodiosService episodiosService) {
        this.episodiosService = episodiosService;
    }

    @GetMapping("/episodios")
    public String listarEpisodios(Model model) {
        List<Episodios> lista = episodiosService.findAll();
        model.addAttribute("episodios", lista);
        return "episodios";
    }

    @GetMapping("/episodios/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Episodios episodio = episodiosService.findById(id);
        model.addAttribute("episodio", episodio);
        return "episodio-editar";
    }

    @PostMapping("/episodios/editar")
    public String guardarEdicion(@ModelAttribute("episodio") Episodios episodio) {
        episodiosService.save(episodio);
        return "redirect:/episodios";
    }
}