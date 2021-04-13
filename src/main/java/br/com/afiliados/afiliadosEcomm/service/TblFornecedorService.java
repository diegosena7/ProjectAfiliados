package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.model.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.repositories.TblFornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo que requer tratamento especial. Todos os finalcampos
 * não inicializados recebem um parâmetro,
 */
@RequiredArgsConstructor
@Service
public class TblFornecedorService {

    final private TblFornecedorRepository fornecedorRepository;

    /**
     * Método responsável por retornar uma lista de fornecedores
     * Usamos o stream, map e collect para transformar o objeto Entity
     * em DTO com lambda, mapeia os dados e transforma em lista
     * @return
     */
    public List<TblFornecedorDTO> buscaFornecedor(){
        List<TblFornecedor> lista = fornecedorRepository.findAll();
        return lista.stream().map(forn -> new TblFornecedorDTO(forn)).collect(Collectors.toList());
    }

    /**
     * Método responsável por inserir um fornecedor no BD
     * @param fornecedor
     * @return
     */
   public TblFornecedor criaForncedor(TblFornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
   }

    /**
     * Método responspavel por deletar um forncedor do BD
     * @param idFornecedor
     */
   public void deletaFornecedor(Integer idFornecedor){
        fornecedorRepository.deleteById(idFornecedor);
   }

    /**
     * Método responsável por atualizar um fornecedor
     * @param fornecedor
     * @return
     */
    public TblFornecedor atualizaFornecedor(TblFornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }
}