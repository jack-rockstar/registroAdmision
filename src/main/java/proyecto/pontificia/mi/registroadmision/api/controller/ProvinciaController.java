package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Provincia;
import proyecto.pontificia.mi.registroadmision.api.services.ProvinciaService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/provincia")
    public Response obtenerProvincia(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Provincia> tiposEducacion = provinciaService.obtenerProvincia(pageable);
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

    @PostMapping("/provincia")
    public Response registrarProvincia(@RequestBody Provincia provincia) {
        Response respuesta = new Response();
        try {
            Provincia provincia1 = provinciaService.registrarProvincia(provincia);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(provincia);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/provincia/{id}")
    public Response actualizarProvincia(@PathVariable Integer id, @RequestBody Provincia provincia) {
        Response respuesta = new Response();
        try {
            Provincia provincia1 = provinciaService.actualizarProvincia(id, provincia);
            if (provincia1 != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Provincia actualizado correctamente");
                respuesta.setData(provincia1);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la provincia con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/provincia/{id}")
    public Response eliminarProvincia(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Provincia provincia = provinciaService.eliminarProvincia(id);
            if (provincia != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Provincia eliminado correctamente");
                respuesta.setData(provincia);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la provincia con ese id");
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
