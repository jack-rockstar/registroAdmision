package proyecto.pontificia.mi.registroadmision.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.services.UsuarioService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public Response obtenerUsuario(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Usuario> usuario = usuarioService.obtenerUsuarios(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @GetMapping("/usuario/{id}")
    public Response obtenerUsuario(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Usuario usuario = usuarioService.obtenerUsuarioById(id);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/usuario")
    public Response registrarUsuario(@RequestBody Usuario usuario) {
        Response respuesta = new Response();
        try {
            Usuario usuario1 = usuarioService.registrarUsuario(usuario);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(usuario1);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/usuario/{id}")
    public Response actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Response respuesta = new Response();
        try {
            Usuario usuario1 = usuarioService.actualizarUsuario(id, usuario);
            if (usuario1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Usuario actualizado correctamente");
                respuesta.setData(usuario1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el usuario con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/usuario/{id}")
    public Response eliminarUsuario(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Usuario usuario = usuarioService.eliminarUsuario(id);
            if (usuario != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Usuario eliminado correctamente");
                respuesta.setData(usuario);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el usuario con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }
}
