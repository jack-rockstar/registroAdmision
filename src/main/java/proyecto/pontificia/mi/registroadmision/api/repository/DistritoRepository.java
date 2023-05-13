package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Distrito;

public interface DistritoRepository extends CrudRepository<Distrito, Integer> {
    Page<Distrito> findAll(Pageable pageable);
}
