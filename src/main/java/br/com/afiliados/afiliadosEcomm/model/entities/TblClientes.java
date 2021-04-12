package br.com.afiliados.afiliadosEcomm.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="tblClientes")
public class TblClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCLiente;

    private String nomeCliente;

    private String emailCliente;

    private String telCliente;

    @CreationTimestamp
    @JsonIgnore
    private Date data;

    private Boolean ativo;

//    @OneToMany(mappedBy = "idProdutos")
//    private Integer idProdutos;
}
