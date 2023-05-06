package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")

    private Integer id;
    private String nombre;
    private String numerdoc;
    private String telefono;
    private String correo;
    private String foto;
    private String fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String user;
    private String pas;

    public enum Rol{
        ADMIN,
        REGISTRADOR
    }


}
