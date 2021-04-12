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
@Table(name="tblFornecedor")
public class TblFornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFornecedor")
    private Integer idFornecedor;

    @Column(name="data")
    @CreationTimestamp
    @JsonIgnore
    private Date data;

    @Column(name="ativo")
    private Boolean ativo;
}
