package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblProdutosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import br.com.afiliados.afiliadosEcomm.service.TblProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
