package br.com.afiliados.afiliadosEcomm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Nesta classe fazemos o controle das exceptions, usando a anotação @ControllerAdvice para capturar as exceptions
 * usamos no método objectNotFound a anotação @ExceptionHandler informando qual classe de exception será tratatada
 * e instanciamos o objeto do tipo StandardError para passar as informações do erro ao usuário.
 */
@ControllerAdvice
public class ResourceExeptionError {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
