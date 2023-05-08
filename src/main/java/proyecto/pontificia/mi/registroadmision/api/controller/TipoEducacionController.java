package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;
import proyecto.pontificia.mi.registroadmision.api.services.TipoEducacionService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoEducacionController {
    @Autowired
    private TipoEducacionService tipoEducacionService;

    @GetMapping("/tipoEducacion")
    public Response obtenerTiposEducacion(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<TipoEducacion> tiposEducacion = tipoEducacionService.obtenerTiposEducacion(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(tiposEducacion);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/tipoEducacion")
    public Response registrarTipoEducacion(@RequestBody TipoEducacion tipoEducacion) {
        Response respuesta = new Response();
        try {
            TipoEducacion tipoEducacionRegistrado = tipoEducacionService.registrarTipoEducacion(tipoEducacion);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(tipoEducacionRegistrado);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/tipoEducacion/{id}")
    public Response actualizarTipoEducacion(@PathVariable Integer id, @RequestBody TipoEducacion tipoEducacion) {
        Response respuesta = new Response();
        try {
            TipoEducacion tipoEducacionActualizado = tipoEducacionService.actualizarTipoEducacion(id, tipoEducacion);
            if (tipoEducacionActualizado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Tipo de educación actualizado correctamente");
                respuesta.setData(tipoEducacionActualizado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el tipo de educación con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/tipoEducacion/{id}")
    public Response eliminarTipoEducacion(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            TipoEducacion tipoEducacionEliminado = tipoEducacionService.eliminarTipoEducacion(id);
            if (tipoEducacionEliminado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Tipo de educación eliminado correctamente");
                respuesta.setData(tipoEducacionEliminado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el tipo de educación con ese id");
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
