package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.exceptions.ObjectNotFoundException;
import br.com.afiliados.afiliadosEcomm.model.dto.TblProdutosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
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

    /**
     * Método responsável por fazer a busca de um afiliado através do id
     * @param idProduto
     * @return
     * @throws ObjectNotFoundException
     */
    public TblProdutos buscaProdutoPorId(Integer idProduto) throws ObjectNotFoundException{
        return produtosRepository.findById(idProduto).orElseThrow(() -> new ObjectNotFoundException
                ("O afiliado para o id: " + idProduto + " não foi localizado."));
    }

    /**
     * Método responsável por inserir um produto na base de dados
     * @param tblProdutos
     * @return
     */
    public TblProdutos inserirProduto(TblProdutos tblProdutos){
        return produtosRepository.save(tblProdutos);
    }

    /**
     * Método responsável por excluir um produto do BD através do id
     * @param idProduto
     */
    public void deleteProduto(Integer idProduto){
        if (idProduto != null){
            produtosRepository.deleteById(idProduto);
        }
    }

    public TblProdutos atualizaFornecedor(TblProdutos produtos){
        return produtosRepository.save(produtos);
    }
}
