package br.com.afiliados.afiliadosEcomm.repositories;

import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblAfiliadosRepository extends JpaRepository<TblAfiliados, Integer> {
}
