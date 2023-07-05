package proyecto.pontificia.mi.registroadmision.api.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, Object> errorDetail = new HashMap<>();
        errorDetail.put("title", "Error de validacion");
        errorDetail.put("code", "invalid_form");
        errorDetail.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());

        List<String> errors = new ArrayList<>();
        for (FieldError fieldError:exception.getBindingResult().getFieldErrors()){
            String message = messageSource.getMessage(fieldError, Locale.getDefault());
            errors.add(message);
        }
        errorDetail.put("errors", errors);
        return  new ResponseEntity<>(errorDetail, HttpStatus.UNPROCESSABLE_ENTITY);

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    void handleEntityNotFoundException(){

    }
}
