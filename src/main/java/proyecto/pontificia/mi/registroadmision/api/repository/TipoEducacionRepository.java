package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;

import java.util.List;

public interface TipoEducacionRepository extends CrudRepository<TipoEducacion, Integer> {

    Page<TipoEducacion> findAll(Pageable pageable);
}
