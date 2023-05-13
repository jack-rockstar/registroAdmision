package proyecto.pontificia.mi.registroadmision.api.DTO;

import jakarta.validation.constraints.NotBlank;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;

public class CarrerasDto {
    @NotBlank
    private String nombreCarrera;

    @NotBlank
    private TipoEducacion tipoEducacion;
}
