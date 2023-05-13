package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.TipoPersona;

public interface TipoPersonaRepository extends CrudRepository<TipoPersona, Integer> {
    Page<TipoPersona> findAll(Pageable pageable);
}
