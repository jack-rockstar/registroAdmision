package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Distrito;
import proyecto.pontificia.mi.registroadmision.api.services.DistritoService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distrito")
    public Response obtenerDistrito(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Distrito> distritos = distritoService.obtenerDistrito(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(distritos);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/distrito")
    public Response registrarDistrito(@RequestBody Distrito distrito) {
        Response respuesta = new Response();
        try {
            Distrito distritoRegistrado = distritoService.registrarDistrito(distrito);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(distritoRegistrado);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/distrito/{id}")
    public Response actualizarDistrito(@PathVariable Integer id, @RequestBody Distrito distrito) {
        Response respuesta = new Response();
        try {
            Distrito distrito1 = distritoService.actualizarDistrito(id, distrito);
            if (distrito1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Distrito actualizado correctamente");
                respuesta.setData(distrito1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el distrito con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/distrito/{id}")
    public Response eliminarDistrito(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Distrito distritoEliminado = distritoService.eliminarDistrito(id);
            if (distritoEliminado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Distrito eliminado correctamente");
                respuesta.setData(distritoEliminado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el distrito con ese id");
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
