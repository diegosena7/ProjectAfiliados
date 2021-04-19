package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblFornecedorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFornecedor;
    private Date data;
    private Boolean ativo;

    //Construtor com parâmetros da Entity
    public TblFornecedorDTO (TblFornecedor fornecedor){
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.data = fornecedor.getData();
        this.ativo = fornecedor.getAtivo();
    }
}
