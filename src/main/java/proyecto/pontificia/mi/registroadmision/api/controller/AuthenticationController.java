package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> login(@RequestBody LoginDto usuario) {
        Response respuesta = new Response();
        try {
            Usuario user = authenticationService.login(usuario);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(user);
            return  ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
