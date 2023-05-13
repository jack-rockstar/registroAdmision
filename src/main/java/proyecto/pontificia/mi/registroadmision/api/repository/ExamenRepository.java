package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Integer> {
    Page<Examen> findAll(Pageable pageable);
}
