package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carreras")
public class Carreras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Integer id;

    private String nombreCarrera;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoEducacion")
    private TipoEducacion tipoEducacion;
}
