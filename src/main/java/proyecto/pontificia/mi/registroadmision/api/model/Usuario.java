package proyecto.pontificia.mi.registroadmision.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;
    private String genero;
    @Column(name = "user", unique = true)
    private String user;
    private String ubigeo;
    private String contraseña;
    @OneToOne()
    @JoinColumn(name = "idCarrera")
    private Carreras carrera;
    @OneToOne()
    @JoinColumn(name = "idTipoPersona")
    private TipoPersona tipoPersona;
}
