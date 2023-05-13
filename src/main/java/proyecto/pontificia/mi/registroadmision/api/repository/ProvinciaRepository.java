package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Provincia;

public interface ProvinciaRepository extends CrudRepository<Provincia, Integer> {
    Page<Provincia> findAll(Pageable pageable);
}
