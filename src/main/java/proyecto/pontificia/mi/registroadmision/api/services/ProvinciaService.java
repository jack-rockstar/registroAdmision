package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Provincia;

import java.util.List;

public interface ProvinciaService {
    Provincia registrarProvincia(Provincia provincia);

    List<Provincia> obtenerProvincia(Pageable pageable);

    Provincia actualizarProvincia(Integer id, Provincia provincia);

    Provincia eliminarProvincia(Integer id);
}
