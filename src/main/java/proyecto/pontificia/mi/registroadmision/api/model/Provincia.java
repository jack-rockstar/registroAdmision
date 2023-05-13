package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvincia")


    private Integer id;
    private String nombreProvincia;

    @ManyToOne
    @JoinColumn (name="idDepartamento")
    private Departamento Departamento;


}
