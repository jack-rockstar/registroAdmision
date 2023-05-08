package proyecto.pontificia.mi.registroadmision.api.utils;

import lombok.Data;

@Data
public class Response<T> {
    private Integer codigoRespuesta;
    private String mensajeRespuesta;
    private T data;
}
