package com.nasa.asteroides_peligrosos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Map;
import java.util.List;

// DTO principal que mapea la respuesta completa de la API NeoWs de NASA
@Data
public class RespuestaNeoWs {

    // Número total de asteroides en la respuesta
    @JsonProperty("element_count")
    private Integer cantidadElementos;


     // Mapa donde la clave es la fecha (String) y el valor es una lista de asteroides

    @JsonProperty("near_earth_objects")
    private Map<String, List<Asteroide>> objetosCercanosATierra;
}