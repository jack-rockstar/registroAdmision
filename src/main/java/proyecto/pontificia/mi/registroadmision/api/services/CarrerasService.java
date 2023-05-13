package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Carreras;

import java.util.List;

public interface CarrerasService {
    Carreras registrarCarreras(Carreras carreras);

    List<Carreras> obtenerCarreras(Pageable pageable);

    Carreras actualizarCarreras(Integer id, Carreras carreras);

    Carreras eliminarCarreras(Integer id);
}
