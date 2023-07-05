package proyecto.pontificia.mi.registroadmision.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Page<Usuario> findAll(Pageable pageable);
    Usuario findOneByUserIgnoreCaseAndContraseña(String user, String contraseña);
    Usuario findOneByUserAndContraseña(String user, String contraseña);
}
