package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblAfiliadosDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAfiliado;
    private String nomeAfiliado;
    private Date data;
    private Boolean ativo;

    //Construtor com parâmetros da Entity
    public TblAfiliadosDTO(TblAfiliados afiliados) {
        this.idAfiliado = afiliados.getIdAfiliado();
        this.nomeAfiliado = afiliados.getNomeAfiliado();
        this.data = afiliados.getData();
        this.ativo = afiliados.getAtivo();
    }
}
