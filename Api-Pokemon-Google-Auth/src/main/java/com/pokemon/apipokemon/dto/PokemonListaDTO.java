package com.pokemon.apipokemon.dto;

import lombok.Data;
import java.util.List;

@Data
public class PokemonListaDTO {
    private Integer count;
    private String next;
    private String previous;
    private List<PokemonBasicoDTO> results;

    @Data
    public static class PokemonBasicoDTO {
        private String name;
        private String url;
    }
}