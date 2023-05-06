package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprovincia")


    private Integer id;
    private String nomprovincia;
    private String ubigeo;
    private Float longitud;
    private Float latitud;

    @ManyToOne
    @JoinColumn (name="iddepartamento",referencedColumnName = "iddepartamento" )
    private Departamento iddepartamento;


}
