package br.com.afiliados.afiliadosEcomm.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Nesta classe estamos mapeando a entidade para fazer o relacionamento com o idProdutos
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tblClientes")
public class TblClientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nomeCliente;

    private String emailCliente;

    private String telCliente;

    @CreationTimestamp
    @JsonIgnore
    private Date data;

    private Boolean ativo;

//    @OneToMany(mappedBy = "idProdutos")
//    @JoinTable(name = "idProdutos")
//    private TblProdutos idProdutos;
}
