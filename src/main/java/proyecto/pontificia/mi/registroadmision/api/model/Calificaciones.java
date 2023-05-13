package proyecto.pontificia.mi.registroadmision.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalificaciones")
    private Integer id;
    private Float nota;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario estudiante;
    @OneToOne
    @JoinColumn(name = "idExamen")
    private Examen examen;
}
