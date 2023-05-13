package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.services.ExamenService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping("/examen")
    public Response obtenerExamen(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Examen> examen = examenService.obtenerExamen(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(examen);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/examen")
    public Response registrarExamen(@RequestBody Examen examen) {
        Response respuesta = new Response();
        try {
            Examen examen1 = examenService.registrarExamen(examen);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(examen1);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/examen/{id}")
    public Response actualizarExamen(@PathVariable Integer id, @RequestBody Examen examen) {
        Response respuesta = new Response();
        try {
            Examen examen1 = examenService.actualizarExamen(id, examen);
            if (examen1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Examen actualizado correctamente");
                respuesta.setData(examen1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el examen con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/examen/{id}")
    public Response eliminarExamen(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Examen examen = examenService.eliminarExamen(id);
            if (examen != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Examen eliminado correctamente");
                respuesta.setData(examen);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el examen con ese id");
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
