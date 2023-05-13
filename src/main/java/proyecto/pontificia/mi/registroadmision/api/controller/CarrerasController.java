package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Carreras;
import proyecto.pontificia.mi.registroadmision.api.repository.CarrerasRepository;
import proyecto.pontificia.mi.registroadmision.api.services.CarrerasService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarrerasController {
    @Autowired
    private CarrerasService carrerasService;

    @Autowired
    private CarrerasRepository carrerasRepository;

    @GetMapping("/carreras")
    public Response obtenerCarreras(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Carreras> carrerasList = carrerasService.obtenerCarreras(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(carrerasList);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @GetMapping("/carreras/{id}")
    public Response obtenerCarrera(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Carreras carreras = carrerasService.obtenerCarreraById(id);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(carreras);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PostMapping("/carreras")
    public Response registrarCarreras(@RequestBody Carreras carreras) {
        Response respuesta = new Response();
        try {
            Carreras carreras1 = carrerasService.registrarCarreras(carreras);
            if(carreras1 != null){
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Operacion correcta");
                respuesta.setData(carreras1);
            } else {
                respuesta.setCodigoRespuesta(400);
                respuesta.setMensajeRespuesta("Error al crear");
                respuesta.setData(carreras1);
            }

        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/carrera/{id}")
    public Response actualizarCarreras(@PathVariable Integer id, @RequestBody Carreras carrera) {
        Response respuesta = new Response();
        try {
            Carreras carreraActualizado = carrerasService.actualizarCarreras(id, carrera);
            if (carreraActualizado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Carrera actualizado correctamente");
                respuesta.setData(carreraActualizado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la carrera con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/carrera/{id}")
    public Response eliminarCarrera(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Carreras carreraEliminada = carrerasService.eliminarCarreras(id);
            if (carreraEliminada != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Carrera eliminado correctamente");
                respuesta.setData(carreraEliminada);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró la carrera con ese id");
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
