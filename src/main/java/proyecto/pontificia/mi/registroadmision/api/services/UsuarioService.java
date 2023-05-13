package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.data.domain.Pageable;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);

    List<Usuario> obtenerUsuarios(Pageable pageable);

    Usuario actualizarUsuario(Integer id, Usuario usuario);

    Usuario eliminarUsuario(Integer id);
}
