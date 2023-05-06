package proyecto.pontificia.mi.registroadmision.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Califaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalificacion")
    private Integer id;

    private long idEstudiante;
    private long idExamen;
    private String nota;
}
