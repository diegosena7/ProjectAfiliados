package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.model.dto.TblProdutosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import br.com.afiliados.afiliadosEcomm.repositories.TblProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TblProdutosService {

    final private TblProdutosRepository produtosRepository;

    /** Método responsável por fazer a busca dos produtos usando o método findAll da classe TblProdutosRepository
     * @return lista com todos os produtos
     */
    public List<TblProdutosDTO> buscaProdutos(){
        List<TblProdutos> listaProdutos = produtosRepository.findAll();
        return listaProdutos.stream().map(produto -> new TblProdutosDTO(produto)).collect(Collectors.toList());
    }



}
