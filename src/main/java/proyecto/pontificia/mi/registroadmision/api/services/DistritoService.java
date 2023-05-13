package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Distrito;

import java.util.List;

public interface DistritoService {
    Distrito registrarDistrito(Distrito distrito);

    List<Distrito> obtenerDistrito(Pageable pageable);

    Distrito actualizarDistrito(Integer id, Distrito distrito);

    Distrito eliminarDistrito(Integer id);
}
