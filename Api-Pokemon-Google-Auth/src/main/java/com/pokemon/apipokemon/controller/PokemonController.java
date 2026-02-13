package com.pokemon.apipokemon.controller;

import com.pokemon.apipokemon.dto.PokemonDTO;
import com.pokemon.apipokemon.dto.PokemonListaDTO;
import com.pokemon.apipokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/")
    public String paginaInicio(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null) {
            model.addAttribute("userName", principal.getAttribute("name"));
            model.addAttribute("userEmail", principal.getAttribute("email"));
            model.addAttribute("userPicture", principal.getAttribute("picture"));
        }
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/buscar")
    public String buscarPokemon(@RequestParam("nombreOId") String nombreOId,
                                @AuthenticationPrincipal OAuth2User principal,
                                Model model) {
        if (principal != null) {
            model.addAttribute("userName", principal.getAttribute("name"));
            model.addAttribute("userEmail", principal.getAttribute("email"));
            model.addAttribute("userPicture", principal.getAttribute("picture"));
        }

        PokemonDTO pokemon = pokemonService.buscarPokemon(nombreOId);

        if (pokemon == null) {
            model.addAttribute("error", "Pokémon no encontrado");
            return "index";
        }

        model.addAttribute("pokemon", pokemon);
        return "detalle";
    }

    @GetMapping("/lista")
    public String listarPokemon(@RequestParam(value = "limite", defaultValue = "20") int limite,
                                @AuthenticationPrincipal OAuth2User principal,
                                Model model) {
        if (principal != null) {
            model.addAttribute("userName", principal.getAttribute("name"));
            model.addAttribute("userEmail", principal.getAttribute("email"));
            model.addAttribute("userPicture", principal.getAttribute("picture"));
        }

        PokemonListaDTO lista = pokemonService.obtenerListaPokemon(limite);
        model.addAttribute("lista", lista);
        return "lista";
    }
}