package proyecto.pontificia.mi.registroadmision.api.services;

import proyecto.pontificia.mi.registroadmision.api.DTO.LoginDto;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;

public interface AuthenticationService {
    Usuario login(LoginDto user);
}
