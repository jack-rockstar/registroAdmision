package proyecto.pontificia.mi.registroadmision.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @GetMapping
    String holaMundo(){
        return "hola mundo!";
    }
}
