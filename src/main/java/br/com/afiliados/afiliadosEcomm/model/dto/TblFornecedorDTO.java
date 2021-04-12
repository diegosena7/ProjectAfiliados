package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TblFornecedorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFornecedor;
    private Date data;
    private Boolean ativo;

    public TblFornecedorDTO (TblFornecedor fornecedor){
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.data = fornecedor.getData();
        this.ativo = fornecedor.getAtivo();
    }
}
