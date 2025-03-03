package br.com.mscompra.mscompra.controller.exceptions;

import br.com.commonslib.dtos.response.FieldErrorDto;
import br.com.commonslib.dtos.response.StandardErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
public class StandardErrorExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorResponseDto> handleHibernateValidation(HttpServletRequest httpServletRequest,
                                                                              MethodArgumentNotValidException exception){
        int badRequest = HttpStatus.BAD_REQUEST.value();
        String pathUrl = httpServletRequest.getRequestURI();
        Set<FieldErrorDto> errors = getValidationErrors(exception);
        StandardErrorResponseDto standardErrorResponseDto =  new StandardErrorResponseDto(Instant.now(), badRequest,
                "Hibernate Validation Exception", pathUrl, "Hibernate Exception", "Please validate the payload", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardErrorResponseDto);
    }

    private static Set<FieldErrorDto> getValidationErrors(MethodArgumentNotValidException exception){
        Set<FieldErrorDto> errors = new HashSet<>();
        exception.getFieldErrors().forEach( fieldError -> {
            errors.add(new FieldErrorDto(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return errors;
    }
}
