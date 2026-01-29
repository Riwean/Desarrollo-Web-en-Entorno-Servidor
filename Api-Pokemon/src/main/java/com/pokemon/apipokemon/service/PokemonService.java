package com.pokemon.apipokemon.service;

import com.pokemon.apipokemon.cliente.ClientePokeApi;
import com.pokemon.apipokemon.dto.PokemonDTO;
import com.pokemon.apipokemon.dto.PokemonListaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonService {

    private final ClientePokeApi clientePokeApi;

    public PokemonDTO buscarPokemon(String nombreOId) {
        try {
            log.info("Buscando Pokémon: {}", nombreOId);
            return clientePokeApi.obtenerPokemonPorNombreOId(nombreOId);
        } catch (HttpClientErrorException.NotFound e) {
            log.error("Pokémon no encontrado: {}", nombreOId);
            return null;
        } catch (Exception e) {
            log.error("Error al buscar Pokémon: {}", e.getMessage());
            throw new RuntimeException("Error al conectar con PokéAPI", e);
        }
    }

    public PokemonListaDTO obtenerListaPokemon(int limite) {
        try {
            log.info("Obteniendo lista de {} Pokémon", limite);
            return clientePokeApi.obtenerListaPokemon(limite);
        } catch (Exception e) {
            log.error("Error al obtener lista de Pokémon: {}", e.getMessage());
            throw new RuntimeException("Error al conectar con PokéAPI", e);
        }
    }
}