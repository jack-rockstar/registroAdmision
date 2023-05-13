package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Departamento;

import java.util.List;

public interface DepartamentoService {
    Departamento registrarDepartamento(Departamento Departamento);

    List<Departamento> obtenerDepartamento(Pageable pageable);

    Departamento actualizarDepartamento(Integer id, Departamento Departamento);

    Departamento eliminarDepartamento(Integer id);
}
