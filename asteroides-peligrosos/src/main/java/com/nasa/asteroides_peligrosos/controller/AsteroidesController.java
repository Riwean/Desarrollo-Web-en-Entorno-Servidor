package com.nasa.asteroides_peligrosos.controller;

import com.nasa.asteroides_peligrosos.dto.Asteroide;
import com.nasa.asteroides_peligrosos.model.Consulta;
import com.nasa.asteroides_peligrosos.repository.ConsultaRepository;
import com.nasa.asteroides_peligrosos.service.AsteroidesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class AsteroidesController {

    private final AsteroidesService asteroidesService;
    private final ConsultaRepository consultaRepository;

    // Inyección de dependencias por constructor
    public AsteroidesController(AsteroidesService asteroidesService, ConsultaRepository consultaRepository) {
        this.asteroidesService = asteroidesService;
        this.consultaRepository = consultaRepository;
    }

    // GET / - Muestra el formulario inicial
    @GetMapping("/")
    public String mostrarFormulario() {
        return "index";
    }

    // POST /consultar - Procesa el formulario y muestra resultados
    @PostMapping("/consultar")
    public String consultarAsteroides(
            @RequestParam("fecha") String fechaStr,
            Model model,
            Authentication authentication) {

        try {
            // Validar que la fecha no esté vacía
            if (fechaStr == null || fechaStr.trim().isEmpty()) {
                model.addAttribute("error", "Debe seleccionar una fecha");
                return "index";
            }

            // Convertir String a LocalDate
            LocalDate fecha = LocalDate.parse(fechaStr);

            // Llamar al servicio para obtener asteroides peligrosos
            List<Asteroide> asteroidesPeligrosos = asteroidesService.obtenerAsteroidesPeligrosos(fecha);

            // Guardar consulta en el historial
            String nombreUsuario = authentication != null ? authentication.getName() : "anónimo";
            Consulta consulta = new Consulta(fecha, asteroidesPeligrosos.size(), nombreUsuario);
            consultaRepository.save(consulta);

            // Añadir datos al modelo para la vista
            model.addAttribute("fecha", fechaStr);
            model.addAttribute("asteroides", asteroidesPeligrosos);

            // Devolver la vista de resultados
            return "resultado"; //

        } catch (DateTimeParseException e) {
            // Error al parsear la fecha
            model.addAttribute("error", "Formato de fecha inválido");
            return "index";

        } catch (Exception e) {
            // Error general
            model.addAttribute("error", "Error al consultar la API de NASA. Por favor, inténtelo de nuevo.");
            model.addAttribute("detalleError", e.getMessage());
            return "index";
        }
    }

    // GET /historial
    @GetMapping("/historial")
    public String mostrarHistorial(Model model) {
        List<Consulta> consultas = consultaRepository.findTop10ByOrderByFechaHoraConsultaDesc();
        model.addAttribute("consultas", consultas);
        return "historial";
    }
}