package br.com.afiliados.afiliadosEcomm.repositories;

import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblClientesRepository extends JpaRepository<TblClientes, Integer> {
}
