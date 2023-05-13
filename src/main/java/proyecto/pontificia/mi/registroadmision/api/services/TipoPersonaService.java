package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;
import proyecto.pontificia.mi.registroadmision.api.model.TipoPersona;

import java.util.List;

public interface TipoPersonaService {
    TipoPersona registrarTipoPersona(TipoPersona tipoPersona);

    List<TipoPersona> obtenerTiposPersona(Pageable pageable);

    TipoPersona actualizarTipoPersona(Integer id, TipoPersona tipoPersona);

    TipoPersona eliminarTipoPersona(Integer id);
}
