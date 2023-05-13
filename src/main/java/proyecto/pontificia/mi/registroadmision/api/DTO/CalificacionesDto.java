package proyecto.pontificia.mi.registroadmision.api.DTO;

import jakarta.validation.constraints.NotBlank;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;

public class CalificacionesDto {

    @NotBlank
    private Float nota;

   @NotBlank
    private Usuario estudiante;

   @NotBlank
    private Examen examen;
}
