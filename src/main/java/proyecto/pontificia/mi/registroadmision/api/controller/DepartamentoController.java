package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import proyecto.pontificia.mi.registroadmision.api.model.Departamento;
import proyecto.pontificia.mi.registroadmision.api.services.DepartamentoService;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamento")
    public Response obtenerDepartamento(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Response respuesta = new Response();
        try {
            List<Departamento> departamentos = departamentoService.obtenerDepartamento(pageable);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(departamentos);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }

    @PostMapping("/departamento")
    public Response registrarDepartamento(@RequestBody Departamento departamento) {
        Response respuesta = new Response();
        try {
            Departamento depaRegistrado = departamentoService.registrarDepartamento(departamento);
            respuesta.setCodigoRespuesta(200);
            respuesta.setMensajeRespuesta("Operacion correcta");
            respuesta.setData(depaRegistrado);
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return respuesta;
    }


    @PutMapping("/departamento/{id}")
    public Response actualizarDepartamento(@PathVariable Integer id, @RequestBody Departamento departamento) {
        Response respuesta = new Response();
        try {
            Departamento depaActualizado = departamentoService.actualizarDepartamento(id, departamento);
            if (depaActualizado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Departamento actualizado correctamente");
                respuesta.setData(depaActualizado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el departamento con ese id");
                respuesta.setData(null);
            }
        } catch (Exception e) {
            respuesta.setCodigoRespuesta(500);
            respuesta.setMensajeRespuesta("Error en la operacion: " + e.getMessage());
            respuesta.setData(null);
        }
        return  respuesta;
    }

    @DeleteMapping("/departamento/{id}")
    public Response eliminarDepartamento(@PathVariable Integer id) {
        Response respuesta = new Response();
        try {
            Departamento departamentoEliminado = departamentoService.eliminarDepartamento(id);
            if (departamentoEliminado != null) {
                respuesta.setCodigoRespuesta(200);
                respuesta.setMensajeRespuesta("Departamento eliminado correctamente");
                respuesta.setData(departamentoEliminado);
            } else {
                respuesta.setCodigoRespuesta(404);
                respuesta.setMensajeRespuesta("No se encontró el departamento con ese id");
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
