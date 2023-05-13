package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Calificaciones;
import proyecto.pontificia.mi.registroadmision.api.services.CalificacionesService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalificacionesController {
    @Autowired
    private CalificacionesService calificacionesService;

    @GetMapping("/calificacion")
    public Response obtenerCalificaciones(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Calificaciones> califaciones = calificacionesService.obtenerCalificaciones(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(califaciones);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/calificacion")
    public Response registrarCalificacion(@RequestBody Calificaciones calificacion) {
        Response respuesta = new Response();
        try {
            Calificaciones califacionesRegistrado = calificacionesService.registrarCalificaciones(calificacion);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(califacionesRegistrado);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/calificacion/{id}")
    public Response actualizarCalificacion(@PathVariable Integer id, @RequestBody Calificaciones califaciones) {
        Response respuesta = new Response();
        try {
            Calificaciones califaciones1 = calificacionesService.actualizarCalificaciones(id, califaciones);
            if (califaciones1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Calificacion actualizado correctamente");
                respuesta.setData(califaciones1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la calificacion con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/calificacion/{id}")
    public Response eliminarCalificacion(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Calificaciones califaciones = calificacionesService.eliminarCalificaciones(id);
            if (califaciones != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Calificacion eliminado correctamente");
                respuesta.setData(califaciones);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la calificacion con ese id");
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
