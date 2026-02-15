package com.nasa.asteroides_peligrosos.service;

import com.nasa.asteroides_peligrosos.dto.Asteroide;
import com.nasa.asteroides_peligrosos.dto.RespuestaNeoWs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsteroidesService {

    // Inyectar valores desde application.properties
    @Value("${nasa.api.url}")
    private String apiUrl;

    @Value("${nasa.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    // Constructor - Spring inyecta RestTemplate automáticamente
    public AsteroidesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Metodo principal: consulta la API y devuelve solo asteroides peligrosos
    public List<Asteroide> obtenerAsteroidesPeligrosos(LocalDate fecha) {

        // Construir la URL con los parámetros
        String fechaStr = fecha.toString();
        String urlCompleta = String.format("%s?start_date=%s&end_date=%s&api_key=%s",
                apiUrl, fechaStr, fechaStr, apiKey);

        //Hacer la llamada HTTP GET a la API de NASA
        RespuestaNeoWs respuesta = restTemplate.getForObject(urlCompleta, RespuestaNeoWs.class);

        // Validar que la respuesta no sea null
        if (respuesta == null || respuesta.getObjetosCercanosATierra() == null) {
            return new ArrayList<>(); // Devolver lista vacía si no hay datos
        }

        // Extraer la lista de asteroides para la fecha consultada
        List<Asteroide> asteroidesDelDia = respuesta.getObjetosCercanosATierra()
                .getOrDefault(fechaStr, new ArrayList<>());

        // Filtrar solo los asteroides potencialmente peligrosos usando streams
        return asteroidesDelDia.stream()
                .filter(asteroide -> asteroide.getEsPotencialmentePeligroso() != null
                        && asteroide.getEsPotencialmentePeligroso())
                .collect(Collectors.toList());
    }
}