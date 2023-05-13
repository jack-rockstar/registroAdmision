package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;

import java.util.List;

public interface PreguntasService {

    Preguntas registrarPreguntas(Preguntas preguntas);

    List<Preguntas> obtenerPreguntas(Pageable pageable);

    Preguntas actualizarPreguntas(Integer id, Preguntas preguntas);

    Preguntas eliminarPreguntas(Integer id);
}
