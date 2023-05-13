package proyecto.pontificia.mi.registroadmision.api.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String tipoDoc;
    @NotBlank
    private String numeroDoc;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotBlank
    private Date fechaNacimiento;
    @NotBlank
    private String genero;
    @NotBlank
    private String user;
    @NotBlank
    @Size(min = 6, max =6 )
    private String ubigeo;

    @NotBlank
    @Size(min = 10, max = 99)
    private String contraseña;
}
