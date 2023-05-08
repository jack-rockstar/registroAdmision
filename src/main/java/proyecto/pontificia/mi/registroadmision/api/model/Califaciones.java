package proyecto.pontificia.mi.registroadmision.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Califaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalificaicon")
    private Integer id;
    private String nota;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idEstudiante;
    @OneToOne
    @JoinColumn(name = "id")
    private Examen idExamen;
}
