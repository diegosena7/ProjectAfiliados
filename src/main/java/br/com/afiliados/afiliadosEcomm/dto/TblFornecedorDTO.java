package br.com.afiliados.afiliadosEcomm.dto;

import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
