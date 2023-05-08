package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;

import java.util.List;


public interface TipoEducacionService {

    TipoEducacion registrarTipoEducacion(TipoEducacion tipoEducacion);
    List<TipoEducacion> obtenerTiposEducacion(Pageable pageable);

    TipoEducacion actualizarTipoEducacion(Integer id, TipoEducacion tipoEducacion);

    TipoEducacion eliminarTipoEducacion(Integer id);

}
