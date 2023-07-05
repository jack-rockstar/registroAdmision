package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Carreras;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;
import proyecto.pontificia.mi.registroadmision.api.model.TipoPersona;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.repository.CarrerasRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.TipoPersonaRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public Usuario registrarUsuario(Usuario dataUsuario){
        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(dataUsuario.getNombre());
            usuario.setApellidos(dataUsuario.getApellidos());
            usuario.setTipoDoc(dataUsuario.getTipoDoc());
            usuario.setNumeroDoc(dataUsuario.getNumeroDoc());
            usuario.setTelefono(dataUsuario.getTelefono());
            usuario.setCorreo(dataUsuario.getCorreo());
            usuario.setFechaNacimiento(dataUsuario.getFechaNacimiento());
            usuario.setUser(dataUsuario.getUser());
            usuario.setGenero(dataUsuario.getGenero());
            usuario.setUbigeo(dataUsuario.getUbigeo());
            usuario.setContraseña(dataUsuario.getContraseña());
            if(dataUsuario.getCarrera() != null){
                Carreras carreras = carrerasRepository.findById(dataUsuario.getCarrera().getId()).orElseThrow(() -> new RuntimeException("Carrera no encontrado"));
                usuario.setCarrera(carreras);
            }



            TipoPersona tipoPersona = tipoPersonaRepository.findById(dataUsuario.getTipoPersona().getId()).orElseThrow(() -> new RuntimeException("Tipo Persona no encontrado"));

            usuario.setTipoPersona(tipoPersona);


            return usuarioRepository.save(usuario);
        }catch (Exception e){
            throw new EntityNotFoundException(e);
        }
    }

    @Override
    public Usuario actualizarUsuario(Integer id, Usuario dataUsuario){
        try {
            Usuario usuarioActual = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            usuarioActual.setNombre(dataUsuario.getNombre());
            usuarioActual.setApellidos(dataUsuario.getApellidos());
            usuarioActual.setTipoDoc(dataUsuario.getTipoDoc());
            usuarioActual.setNumeroDoc(dataUsuario.getNumeroDoc());
            usuarioActual.setTelefono(dataUsuario.getTelefono());
            usuarioActual.setCorreo(dataUsuario.getCorreo());
            usuarioActual.setFechaNacimiento(dataUsuario.getFechaNacimiento());
            usuarioActual.setUser(dataUsuario.getUser());
            usuarioActual.setUbigeo(dataUsuario.getUbigeo());
            usuarioActual.setGenero(dataUsuario.getGenero());
            usuarioActual.setContraseña(dataUsuario.getContraseña());
            //usuarioActual.setCarrera(dataUsuario.getCarrera());
            if(dataUsuario.getCarrera() != null){
                Carreras carreras = carrerasRepository.findById(dataUsuario.getCarrera().getId()).orElseThrow(() -> new RuntimeException("Carrera no encontrado"));
                usuarioActual.setCarrera(carreras);
            }


            TipoPersona tipoPersona = tipoPersonaRepository.findById(dataUsuario.getTipoPersona().getId()).orElseThrow(() -> new RuntimeException("Tipo Persona no encontrado"));

            usuarioActual.setTipoPersona(tipoPersona);

            return usuarioRepository.save(usuarioActual);
        }catch (Exception e){
            throw new EntityNotFoundException(e);
        }
    }

    @Override
    public Usuario eliminarUsuario(Integer id) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            usuarioRepository.deleteById(id);
            return usuario;
        }catch (Exception e){
            throw new EntityNotFoundException("Error usuario no encontrado ", e);
        }
    }

    @Override
    public List<Usuario> obtenerUsuarios(Pageable pageable){
        try {
            Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
            return usuarios.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Usuario obtenerUsuarioById(Integer id){
        try {
            Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            return usuario;
        }catch (Exception e){
            throw new EntityNotFoundException("Error usuario no encontrado ", e);
        }
    }

}
