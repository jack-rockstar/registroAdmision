package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.DTO.LoginDto;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.services.AuthenticationService;
import proyecto.pontificia.mi.registroadmision.api.services.UsuarioService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginDto usuario) {
        Response respuesta = new Response();
        try {
            Usuario user = authenticationService.login(usuario);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(user);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

}
