package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblClientesDTO {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;
    private String nomeCliente;
    private String emailCliente;
    private String telCliente;
    private Date data;
    private Boolean ativo;

    public TblClientesDTO(TblClientes cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.telCliente = cliente.getTelCliente();
        this.data = cliente.getData();
        this.ativo = cliente.getAtivo();
    }
}