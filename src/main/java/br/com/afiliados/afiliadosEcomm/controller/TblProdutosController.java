package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblProdutosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import br.com.afiliados.afiliadosEcomm.repositories.TblProdutosRepository;
import br.com.afiliados.afiliadosEcomm.service.TblProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class TblProdutosController {

    final TblProdutosService produtosService;
    final TblProdutosRepository produtosRepository;

    @GetMapping
    public ResponseEntity<List<TblProdutosDTO>> buscaProdutos(){
        List<TblProdutosDTO> listaProdutos = produtosService.buscaProdutos();
        return ResponseEntity.ok().body(listaProdutos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblProdutos inserirProduto(@RequestBody TblProdutos tblProdutos){
        return produtosService.inserirProduto(tblProdutos);
    }

    @DeleteMapping(value = "/{idProduto}")
    public ResponseEntity<TblProdutos> deleteProduto(@PathVariable("idProduto") Integer idProduto){
        produtosService.deleteProduto(idProduto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{idFornecedor}")
    public ResponseEntity atualizarFornecedor(@PathVariable("idFornecedor") Integer idFornecedor, @RequestBody TblProdutos produtos){
        return produtosRepository.findById(idFornecedor).map(
                dados -> {
                    dados.setIdProdutoPlataforma(produtos.getIdProdutoPlataforma());
                    dados.setNomeProduto(produtos.getNomeProduto());
                    dados.setDescricaoProduto(produtos.getDescricaoProduto());
                    dados.setPrecoProduto(produtos.getPrecoProduto());
                    dados.setNomePlataforma(produtos.getNomePlataforma());
                    dados.setCategoriaProduto(produtos.getCategoriaProduto());
                    dados.setLinkInterno(produtos.getLinkInterno());
                    dados.setLinkExterno(produtos.getLinkExterno());
                    dados.setAtivo(produtos.getAtivo());
                    TblProdutos tblProdutos = produtosRepository.save(dados);
                    return ResponseEntity.ok().body(tblProdutos);
                }).orElse(ResponseEntity.notFound().build());
    }
}
