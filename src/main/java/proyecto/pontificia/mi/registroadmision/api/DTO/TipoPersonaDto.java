package proyecto.pontificia.mi.registroadmision.api.DTO;

import jakarta.validation.constraints.NotBlank;

public class TipoPersonaDto {
    @NotBlank
    private String descripcion;
}
