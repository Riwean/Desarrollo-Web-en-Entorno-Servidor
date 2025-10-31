package daw.dmc.helloworld.controller;

import daw.dmc.helloworld.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // Cuando accedamos a esta URL, accederemos a este controlador.
    @GetMapping("/greeting")
    public String userGreeting(Model model) { // Nombre del controlador

        model.addAttribute("message", "¡Bienvenido!"); // Envíamos un String message a la plantilla
        User userObject = new User("Dani", "Dani@example.com"); // Accedemos al modelo para crear un objeto
        model.addAttribute("userObject", userObject); // Envíamos un objeto a la plantilla
        return "user-greeting"; // Plantilla que utilizará este controlador
    }

    @GetMapping("/helloworld")
    public String greeting(
            @RequestParam(required = false) String username1,
            @RequestParam(required = false)String username2,
            Model model) {
        model.addAttribute("message", "Hola " + username1 + " y " + username2);
        return "greeting";
    }
}
