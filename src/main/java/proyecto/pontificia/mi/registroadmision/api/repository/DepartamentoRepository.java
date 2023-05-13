package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {
    Page<Departamento> findAll(Pageable pageable);
}
