package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDistrito")
    private Integer id;

    private String nombreDistrito;
    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia idProvincia;

}
