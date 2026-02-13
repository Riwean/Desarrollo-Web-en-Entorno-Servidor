package com.pokemon.apipokemon.dto;

import lombok.Data;
import java.util.List;

@Data
public class PokemonDTO {
    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private SpritesDTO sprites;
    private List<RanuraTipoDTO> types;

    @Data
    public static class SpritesDTO {
        private String front_default;
    }

    @Data
    public static class RanuraTipoDTO {
        private TipoDTO type;
    }

    @Data
    public static class TipoDTO {
        private String name;
    }
}