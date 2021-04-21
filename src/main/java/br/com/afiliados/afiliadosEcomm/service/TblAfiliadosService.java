package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.model.dto.TblAfiliadosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.repositories.TblAfiliadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TblAfiliadosService {

    final private TblAfiliadosRepository afiliadosRepository;

    /**
     * Método responsável por buscar os afiliados, através do método findAll da Classe TblAfiliadosRepository
     *
     * @return litsa de afiliados
     */
    public List<TblAfiliadosDTO> buscarAfiliados() {
        List<TblAfiliados> afiliados = afiliadosRepository.findAll();
        return afiliados.stream().map(afiliado -> new TblAfiliadosDTO(afiliado)).collect(Collectors.toList());
    }

    /**
     * Método responsável por inserir um afiliado na base de dados
     *
     * @param tblAfiliados
     * @return
     */
    public TblAfiliados inserirAfiliados(TblAfiliados tblAfiliados) {
        return afiliadosRepository.save(tblAfiliados);
    }

    /**
     * Método responsável por excluir um afiliado do BD através do id
     *
     * @param idAfiliado
     */
    public void deletarAfiliado(Integer idAfiliado) {
        afiliadosRepository.deleteById(idAfiliado);
    }

    /**
     * Método responsável por atualizar o objeto do tipo TblAfiliados
     *
     * @param tblAfiliados
     * @return
     */
    public TblAfiliados atualizarAfiliado(TblAfiliados tblAfiliados) {
        return afiliadosRepository.save(tblAfiliados);
    }
}
