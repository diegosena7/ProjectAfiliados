package br.com.afiliados.afiliadosEcomm.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * Nesta classe estamos construindo o objeto que possui os dados do retorno da msg
 */
@AllArgsConstructor
@Data
public class StandardError {
    private Integer status;
    private Long timesTamp;
    private String message;
}
