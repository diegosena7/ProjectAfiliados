package br.com.afiliados.afiliadosEcomm.model.exceptions;

public class ClienteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteException(String msg){
        super(msg);
    }
}
