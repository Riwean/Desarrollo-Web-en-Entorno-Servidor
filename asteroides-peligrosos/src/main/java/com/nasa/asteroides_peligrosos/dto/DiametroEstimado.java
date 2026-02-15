package com.nasa.asteroides_peligrosos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// DTO que representa el diámetro estimado de un asteroide

@Data
public class DiametroEstimado {

    // Diámetro en kilómetros
    @JsonProperty("kilometers")
    private RangoDiametro kilometros;

    // Diámetro en metros
    @JsonProperty("meters")
    private RangoDiametro metros;

    // Clase interna para representar el rango de diámetro
    @Data
    public static class RangoDiametro {

        @JsonProperty("estimated_diameter_min")
        private Double diametroMinimoEstimado;

        @JsonProperty("estimated_diameter_max")
        private Double diametroMaximoEstimado;
    }
}