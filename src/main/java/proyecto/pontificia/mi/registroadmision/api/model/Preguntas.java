package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Preguntas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Integer idExamen;
    private String descPregunta;
    private String descRespuesta;
    private Boolean estado;
}
