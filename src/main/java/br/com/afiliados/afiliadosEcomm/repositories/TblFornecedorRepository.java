package br.com.afiliados.afiliadosEcomm.repositories;

import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblFornecedorRepository extends JpaRepository<TblFornecedor, Integer> {
//    TblFornecedor deleteFornecedorById(Integer idFornecedor);

//    TblFornecedor deleteById(TblFornecedor idFornecedor);
}
