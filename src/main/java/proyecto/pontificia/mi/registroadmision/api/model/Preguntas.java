package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Preguntas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPreguntas")
    private Integer id;
    private String descPregunta;
    private String descRespuesta;

    @ManyToOne()
    @JoinColumn(name = "idExamen")
    private Examen idExamen;

}
