package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;

import java.util.List;

public interface ExamenService {
    Examen registrarExamen(Examen examen);

    List<Examen> obtenerExamen(Pageable pageable);

    Examen actualizarExamen(Integer id, Examen examen);

    Examen eliminarExamen(Integer id);

    Examen obtenerExamenById(Integer id);
}
