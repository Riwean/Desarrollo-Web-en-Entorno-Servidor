package com.adopta.demo.controller;

import com.adopta.demo.model.Mascota;
import org.springframework.ui.Model;
import com.adopta.demo.service.MascotaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class MascotaViewController {

    private final MascotaService mascotaService;

    public MascotaViewController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // GET Mostrar detalle de una mascota especifica por ID
    @GetMapping("/mascotas/{id}")
    public String verDetalles (@PathVariable Long id, Model model) {

        Mascota mascota = mascotaService.buscarPorId(id);
        if (mascota == null) {
            return "redirect:/mascotas";
        }

        model.addAttribute("mascota", mascota);
        return "detalle";
    }

    // GET Mostrar listado (con filtros opcionales)
    @GetMapping("/mascotas")
    public String verListado(@RequestParam(required = false) String nombre,
                             @RequestParam(required = false) String especie,
                             Model model) {

        List<Mascota> mascotas;

        // Si hay filtros, buscar con filtros
        if ((nombre != null && !nombre.isBlank()) || (especie != null && !especie.isBlank())) {
            mascotas = mascotaService.buscarConFiltros(nombre, especie);
        } else {
            // Sin filtros, mostrar todas
            mascotas = mascotaService.listarMascotas();
        }

        model.addAttribute("mascotas", mascotas);
        model.addAttribute("nombreBusqueda", nombre); // Para mantener el valor en el input
        model.addAttribute("especieFiltro", especie); // Para mantener el select

        return "lista";
    }
}
