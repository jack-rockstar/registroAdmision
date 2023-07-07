package proyecto.pontificia.mi.registroadmision.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.services.UsuarioService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<Response> obtenerUsuario(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Usuario> usuario = usuarioService.obtenerUsuarios(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Response> obtenerUsuario(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Usuario usuario = usuarioService.obtenerUsuarioById(id);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @PostMapping("/usuario")
    public ResponseEntity<Response> registrarUsuario(@RequestBody Usuario usuario) {
        Response respuesta = new Response();
        try {
            Usuario usuario1 = usuarioService.registrarUsuario(usuario);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario1);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Response> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Response respuesta = new Response();
        try {
            Usuario usuario1 = usuarioService.actualizarUsuario(id, usuario);
            if (usuario1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Usuario actualizado correctamente");
                respuesta.setData(usuario1);
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el usuario con ese id");
                respuesta.setData(null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Response> eliminarUsuario(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Usuario usuario = usuarioService.eliminarUsuario(id);
            if (usuario != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Usuario eliminado correctamente");
                respuesta.setData(usuario);
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el usuario con ese id");
                respuesta.setData(null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
