package com.pruebas.bdd1.controller;

import com.pruebas.bdd1.model.Series;
import com.pruebas.bdd1.services.SeriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/series")
    public String listarSeries(Model model) {
        List<Series> lista = seriesService.findAll();
        model.addAttribute("series", lista);
        return "series"; // series.html
    }

    @GetMapping("/series2")
    public String listarSeriesEditable(Model model) {
        model.addAttribute("series", seriesService.findAll());
        return "series-editable"; // nueva plantilla
    }

    @GetMapping("/series/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Series serie = seriesService.findById(id);
        model.addAttribute("serie", serie);
        return "serie-editar"; // nombre de la vista
    }

    @PostMapping("/series/editar")
    public String guardarEdicion(@ModelAttribute("serie") Series serie) {
        seriesService.save(serie);
        return "redirect:/series2"; // volver a la lista editable
    }



}
