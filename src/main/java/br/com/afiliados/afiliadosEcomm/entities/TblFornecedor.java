package br.com.afiliados.afiliadosEcomm.entities;

import br.com.afiliados.afiliadosEcomm.dto.TblFornecedorDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tblFornecedor")
public class TblFornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFornecedor")
    private Integer idFornecedor;

    @Column(name="data")
    @CreationTimestamp
    private Date data;

    @Column(name="ativo")
    private Boolean ativo;

    public TblFornecedor (TblFornecedorDTO tblFornecedorDTO){
        this.idFornecedor = tblFornecedorDTO.getIdFornecedor();
        this.data = tblFornecedorDTO.getData();
        this.ativo = tblFornecedorDTO.getAtivo();
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
