package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento")

    private Integer id;
    private String nomdepartamento;
    private String ubigeo;
    private Float longitud;
    private Float latitud;

}
