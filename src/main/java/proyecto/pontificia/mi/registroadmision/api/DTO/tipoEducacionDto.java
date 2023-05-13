package proyecto.pontificia.mi.registroadmision.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class tipoEducacionDto {

    @NotBlank
    private String nombre;

    @NotBlank
    @Size(min = 3, max = 40)
    private String nombreCorto;


}
