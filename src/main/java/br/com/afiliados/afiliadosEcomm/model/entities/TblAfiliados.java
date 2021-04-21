package br.com.afiliados.afiliadosEcomm.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblAfiliados")
public class TblAfiliados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAfiliado")
    private Integer idAfiliado;

    @NotBlank//Nome não pode ser vazio
    @Column(name = "nomeAfiliado")
    private String nomeAfiliado;

    @CreationTimestamp
    @JsonIgnore
    @Column(name="data")
    private Date data;

    @Column(name="ativo")
    private Boolean ativo;
}
