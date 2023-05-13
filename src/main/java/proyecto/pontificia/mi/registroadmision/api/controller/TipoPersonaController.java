package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.TipoPersona;
import proyecto.pontificia.mi.registroadmision.api.services.TipoPersonaService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @GetMapping("/tipoPersona")
    public Response obtenerTipoPersona(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<TipoPersona> tipoPersona = tipoPersonaService.obtenerTiposPersona(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(tipoPersona);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/tipoPersona")
    public Response registrarPersona(@RequestBody TipoPersona tipoPersona) {
        Response respuesta = new Response();
        try {
            TipoPersona tipoPersona1 = tipoPersonaService.registrarTipoPersona(tipoPersona);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(tipoPersona1);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/tipoPersona/{id}")
    public Response actualizarTipoPersona(@PathVariable Integer id, @RequestBody TipoPersona tipoPersona) {
        Response respuesta = new Response();
        try {
            TipoPersona tipoPersona1 = tipoPersonaService.actualizarTipoPersona(id, tipoPersona);
            if (tipoPersona1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Tipo de persona actualizado correctamente");
                respuesta.setData(tipoPersona1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el tipo de persona con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/tipoPersona1/{id}")
    public Response eliminarTipoPersona(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            TipoPersona tipoPersona = tipoPersonaService.eliminarTipoPersona(id);
            if (tipoPersona != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Tipo de persona eliminado correctamente");
                respuesta.setData(tipoPersona);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el tipo de persona con ese id");
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
