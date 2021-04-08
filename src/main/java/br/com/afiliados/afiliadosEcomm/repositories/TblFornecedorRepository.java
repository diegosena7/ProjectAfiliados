package br.com.afiliados.afiliadosEcomm.repositories;

import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblFornecedorRepository extends JpaRepository<TblFornecedor, Integer> {

}
