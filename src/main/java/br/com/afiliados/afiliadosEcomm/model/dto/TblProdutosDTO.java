package br.com.afiliados.afiliadosEcomm.model.dto;

import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblProdutosDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProdutos;
    private Integer idProdutoPlataforma;
    private String nomeProduto;
    private String descricaoProduto;
    private BigDecimal precoProduto;
    private String nomePlataforma;
    private String categoriaProduto;
    private String linkInterno;
    private String linkExterno;
    private Date data;
    private Boolean ativo;
    private TblAfiliados dadosAfiliado;
    private TblFornecedor dadosFornecedor;

    //Constutor com parâmetros da Entity
    public TblProdutosDTO(TblProdutos produtos) {
        this.idProdutos = produtos.getIdProdutos();
        this.idProdutoPlataforma = produtos.getIdProdutoPlataforma();
        this.nomeProduto = produtos.getNomeProduto();
        this.descricaoProduto = produtos.getDescricaoProduto();
        this.precoProduto = produtos.getPrecoProduto();
        this.nomePlataforma = produtos.getNomePlataforma();
        this.categoriaProduto = produtos.getCategoriaProduto();
        this.linkInterno = produtos.getLinkInterno();
        this.linkExterno = produtos.getLinkExterno();
        this.data = produtos.getData();
        this.ativo = produtos.getAtivo();
        this.dadosAfiliado = produtos.getIdAfiliado();
        this.dadosFornecedor = produtos.getIdFornecedor();
    }
}
