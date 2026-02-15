package com.nasa.asteroides_peligrosos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        // Si hubo error en el login
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }

        // Si el usuario acaba de hacer logout
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión correctamente");
        }

        return "login";
    }
}