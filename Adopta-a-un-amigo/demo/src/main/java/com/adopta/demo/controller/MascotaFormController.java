package com.adopta.demo.controller;

import com.adopta.demo.model.Mascota;
import com.adopta.demo.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MascotaFormController {

    private final MascotaService mascotaService;

    public MascotaFormController (MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }

    // GET: formulario vacío
    @GetMapping("/mascotas/nueva")
    public String formulario (Model model) {
        model.addAttribute("mascota", new Mascota());
        return "form";
    }

    // POST: Recibir y validar
    @PostMapping("/mascotas")
    public String crearMascota(@Valid @ModelAttribute("mascota") Mascota mascota,
                               BindingResult bindingResult,
                               RedirectAttributes ra) {

        // Si especie es "otro", descripción obligatoria
        if ("otro".equalsIgnoreCase(mascota.getEspecie()) &&
                (mascota.getDescripcion() == null || mascota.getDescripcion().isBlank())) {
            bindingResult.rejectValue("descripcion", "error.mascota",
                    "La descripción es obligatoria cuando la especie es 'otro'");
        }

        // Si hay errores, volver al formulario
        if (bindingResult.hasErrors()) {
            return "form";
        }

        // Guardar y redirigir
        Long id = mascotaService.guardar(mascota);
        ra.addAttribute("id", id);
        return "redirect:/mascotas/" + id;
    }

    // POST: Eliminar mascota
    @PostMapping("/mascotas/{id}/eliminar")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return "redirect:/mascotas";
    }

    // GET: Formulario de edición
    @GetMapping("/mascotas/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Mascota mascota = mascotaService.buscarPorId(id);

        if (mascota == null) {
            return "redirect:/mascotas";
        }

        model.addAttribute("mascota", mascota);
        return "editar";
    }

    // POST: Actualizar mascota
    @PostMapping("/mascotas/{id}")
    public String actualizarMascota(@PathVariable Long id,
                                    @Valid @ModelAttribute("mascota") Mascota mascota,
                                    BindingResult bindingResult) {

        // Validación personalizada
        if ("otro".equalsIgnoreCase(mascota.getEspecie()) &&
                (mascota.getDescripcion() == null || mascota.getDescripcion().isBlank())) {
            bindingResult.rejectValue("descripcion", "error.mascota",
                    "La descripción es obligatoria cuando la especie es 'otro'");
        }

        // Si hay errores, volver al formulario de edición
        if (bindingResult.hasErrors()) {
            return "editar";
        }

        // Asegurar que el ID no cambie
        mascota.setId(id);

        // Actualizar
        mascotaService.actualizar(mascota);

        return "redirect:/mascotas/" + id;
    }
}
