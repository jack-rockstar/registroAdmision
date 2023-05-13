package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;
import proyecto.pontificia.mi.registroadmision.api.services.PreguntasService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PreguntasController {

    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("/preguntas")
    public Response obtenerPreguntas(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Preguntas> preguntas = preguntasService.obtenerPreguntas(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(preguntas);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/preguntas")
    public Response registrarPreguntas(@RequestBody Preguntas preguntas) {
        Response respuesta = new Response();
        try {
            Preguntas preguntas1 = preguntasService.registrarPreguntas(preguntas);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(preguntas);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/preguntas/{id}")
    public Response actualizarPreguntas(@PathVariable Integer id, @RequestBody Preguntas preguntas) {
        Response respuesta = new Response();
        try {
            Preguntas preguntas1 = preguntasService.actualizarPreguntas(id, preguntas);
            if (preguntas1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Preguntas actualizado correctamente");
                respuesta.setData(preguntas1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la preguntas con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/preguntas/{id}")
    public Response eliminarPregunta(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Preguntas preguntas = preguntasService.eliminarPreguntas(id);
            if (preguntas != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Pregunta eliminada correctamente");
                respuesta.setData(preguntas);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la preguntas con ese id");
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
