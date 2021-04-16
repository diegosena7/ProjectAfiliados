package br.com.afiliados.afiliadosEcomm.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tblProdutos")
public class TblProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProdutos")
    private Integer idProdutos;

    @Column(name="idProdutoPlataforma")
    private Integer idProdutoPlataforma;

    @Column(name="nomeProduto")
    private String nomeProduto;

    @Column(name="descricaoProduto")
    private String descricaoProduto;

    @Column(name="precoProduto")
    private BigDecimal precoProduto;

    @Column(name="nomePlataforma")
    private String nomePlataforma;

    @Column(name="categoriaProduto")
    private String categoriaProduto;

    @Column(name="linkInterno")
    private String linkInterno;

    @Column(name="linkExterno")
    private String linkExterno;

    @CreationTimestamp
    @JsonIgnore
    @Column(name="data")
    private Date data;

    @Column(name="ativo")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name= "idAfiliado")
    private TblAfiliados idAfiliado;

    @ManyToOne
    @JoinColumn(name = "idFornecedor")
    private TblFornecedor idFornecedor;
}
