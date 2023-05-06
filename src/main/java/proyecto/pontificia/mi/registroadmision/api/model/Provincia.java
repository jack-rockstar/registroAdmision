package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")


    private Integer id;
    private String nombreProvincia;

    @ManyToOne
    @JoinColumn (name="iddepartamento",referencedColumnName = "iddepartamento" )
    private Departamento iddepartamento;


}
