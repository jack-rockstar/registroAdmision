package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;

public interface PreguntasRepository extends CrudRepository<Preguntas, Integer> {
    Page<Preguntas> findAll(Pageable pageable);
}
