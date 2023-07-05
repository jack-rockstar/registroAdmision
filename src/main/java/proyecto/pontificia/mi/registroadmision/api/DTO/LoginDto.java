package proyecto.pontificia.mi.registroadmision.api.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank
    private String user;
    @NotBlank
    private String contraseña;
}
