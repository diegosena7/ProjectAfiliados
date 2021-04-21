package br.com.afiliados.afiliadosEcomm.exceptions;

/**
 * Nesta classe estamos capturando as exceptions para trativa e usando os contrutores para
 * enciar as mensagens de erro para a super classe.
 */
public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
