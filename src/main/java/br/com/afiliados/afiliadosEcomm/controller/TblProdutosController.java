package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblProdutosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
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
}
