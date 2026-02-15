package com.nasa.asteroides_peligrosos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;


// DTO que representa un asteroide individual
@Data
public class Asteroide {

    // ID único del asteroide
    @JsonProperty("id")
    private String id;

    // Nombre del asteroide
    @JsonProperty("name")
    private String nombre;

    // Diámetro estimado del asteroide
    @JsonProperty("estimated_diameter")
    private DiametroEstimado diametroEstimado;

    // Indica si el asteroide es potencialmente peligroso
    @JsonProperty("is_potentially_hazardous_asteroid")
    private Boolean esPotencialmentePeligroso;

    // Lista de aproximaciones cercanas a la Tierra
    @JsonProperty("close_approach_data")
    private List<DatosAproximacion> datosAproximacion;
}
