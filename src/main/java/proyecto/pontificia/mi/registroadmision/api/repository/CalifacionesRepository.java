package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Calificaciones;

public interface CalifacionesRepository extends CrudRepository<Calificaciones, Integer> {
    Page<Calificaciones> findAll(Pageable pageable);
}
