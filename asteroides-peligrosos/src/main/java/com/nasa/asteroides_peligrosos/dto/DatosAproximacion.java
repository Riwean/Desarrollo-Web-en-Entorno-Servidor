package com.nasa.asteroides_peligrosos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// DTO que representa los datos de una aproximación cercana del asteroide a la Tierra
@Data
public class DatosAproximacion {

    // Fecha de aproximación cercana (formato: YYYY-MM-DD)
    @JsonProperty("close_approach_date")
    private String fechaAproximacion;

    // Velocidad relativa del asteroide
    @JsonProperty("relative_velocity")
    private VelocidadRelativa velocidadRelativa;

    // Distancia de paso
    @JsonProperty("miss_distance")
    private DistanciaPaso distanciaPaso;

    // Clase interna para la velocidad relativa
    @Data
    public static class VelocidadRelativa {

        @JsonProperty("kilometers_per_hour")
        private String kilometrosPorHora;

        @JsonProperty("kilometers_per_second")
        private String kilometrosPorSegundo;
    }

    // Clase interna para la distancia de paso
    @Data
    public static class DistanciaPaso {

        @JsonProperty("kilometers")
        private String kilometros;

        @JsonProperty("miles")
        private String millas;
    }
}