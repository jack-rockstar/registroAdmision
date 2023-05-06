package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
