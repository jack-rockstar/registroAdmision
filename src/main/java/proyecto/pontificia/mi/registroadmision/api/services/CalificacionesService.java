package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Calificaciones;

import java.util.List;

public interface CalificacionesService {
    Calificaciones registrarCalificaciones(Calificaciones califaciones);

    List<Calificaciones> obtenerCalificaciones(Pageable pageable);

    Calificaciones actualizarCalificaciones(Integer id, Calificaciones califaciones);

    Calificaciones eliminarCalificaciones(Integer id);
}
