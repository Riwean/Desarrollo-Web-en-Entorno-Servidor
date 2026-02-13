package com.pokemon.apipokemon.cliente;

import com.pokemon.apipokemon.dto.PokemonDTO;
import com.pokemon.apipokemon.dto.PokemonListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ClientePokeApi {

    private static final String URL_BASE = "https://pokeapi.co/api/v2";
    private final RestTemplate restTemplate;

    public PokemonDTO obtenerPokemonPorNombreOId(String nombreOId) {
        String url = URL_BASE + "/pokemon/" + nombreOId.toLowerCase();
        return restTemplate.getForObject(url, PokemonDTO.class);
    }

    public PokemonListaDTO obtenerListaPokemon(int limite) {
        String url = URL_BASE + "/pokemon?limit=" + limite;
        return restTemplate.getForObject(url, PokemonListaDTO.class);
    }
}