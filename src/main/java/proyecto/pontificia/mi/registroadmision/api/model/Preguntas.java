package proyecto.pontificia.mi.registroadmision.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties("preguntas")
    @ManyToOne
    @JoinColumn(name = "idExamen")
    private Examen examen;
}
