package proyecto.pontificia.mi.registroadmision.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idUsuario")

    private Integer id;
    private String nombre;
    private String apellidos;
    private String tipoDoc;
    private String numeroDoc;
    private String telefono;
    private String correo;
    private Date fechaNacimiento;
    private String genero;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String user;
    private String ubigeo;
    private String contraseña;
    @OneToOne()
    @JoinColumn(name = "idCarrera")
    private Carreras idCarrera;
    @OneToOne()
    @JoinColumn(name = "idTipoPersona")
    private Tipopersona idTipoPersona;

    public enum Rol{
        ADMIN,
        ESTUDIANTE
    }


}
