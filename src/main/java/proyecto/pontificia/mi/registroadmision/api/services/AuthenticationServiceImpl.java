package proyecto.pontificia.mi.registroadmision.api.services;

import com.mysql.cj.log.Log;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.DTO.LoginDto;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.repository.UsuarioRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario login(LoginDto user) {
        try{
            Usuario usuario = usuarioRepository.findOneByUserIgnoreCaseAndContraseña(user.getUser(), user.getContraseña());
            if(usuario == null){
                throw new RuntimeException("Usuario no encontrado");
            }
            return  usuario;
        }catch (Exception e){
            throw  new EntityNotFoundException(e);
        }
    }
}
