package com.pokemon.apipokemon.controller;

import com.pokemon.apipokemon.dto.PokemonDTO;
import com.pokemon.apipokemon.dto.PokemonListaDTO;
import com.pokemon.apipokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/")
    public String paginaInicio() {
        return "index";
    }

    @GetMapping("/buscar")
    public String buscarPokemon(@RequestParam("nombreOId") String nombreOId, Model model) {
        PokemonDTO pokemon = pokemonService.buscarPokemon(nombreOId);

        if (pokemon == null) {
            model.addAttribute("error", "Pokémon no encontrado");
            return "index";
        }

        model.addAttribute("pokemon", pokemon);
        return "detalle";
    }

    @GetMapping("/lista")
    public String listarPokemon(@RequestParam(value = "limite", defaultValue = "20") int limite, Model model) {
        PokemonListaDTO lista = pokemonService.obtenerListaPokemon(limite);
        model.addAttribute("lista", lista);
        return "lista";
    }
}