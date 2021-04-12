package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import lombok.Data;

import java.util.Date;

@Data
public class TblClientesDTO {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;
    private String nomeCliente;
    private String emailCliente;
    private String telCliente;
    private Date data;
    private Boolean ativo;

    public TblClientesDTO(TblClientes cliente) {
        this.idCliente = getIdCliente();
        this.nomeCliente = getNomeCliente();
        this.emailCliente = getEmailCliente();
        this.telCliente = getTelCliente();
        this.data = getData();
        this.ativo = getAtivo();
    }
}
