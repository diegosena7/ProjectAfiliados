package br.com.afiliados.afiliadosEcomm.repositories;

import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblFornecedorRepository extends JpaRepository<TblFornecedor, Integer> {

    //Query para atualizar o fornecedor sem setar outra data
    @Query(value = "UPDATE tblFornecedor set ativo = true WHERE idFornecedor = 1",
    nativeQuery = true)
    TblFornecedor getFornecedor();
}
