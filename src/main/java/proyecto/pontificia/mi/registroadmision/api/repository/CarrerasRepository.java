package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Carreras;

public interface CarrerasRepository extends CrudRepository<Carreras, Integer> {
    Page<Carreras> findAll(Pageable pageable);
}
