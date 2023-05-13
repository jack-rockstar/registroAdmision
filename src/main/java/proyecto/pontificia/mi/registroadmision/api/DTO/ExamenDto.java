package proyecto.pontificia.mi.registroadmision.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;

public class ExamenDto {

    @NotBlank
    private String descPregunta;

    @NotBlank
    private String descRespuesta;

    @NotBlank
    private Examen examen;
}
