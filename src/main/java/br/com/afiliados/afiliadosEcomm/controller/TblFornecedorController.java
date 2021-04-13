package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.service.TblFornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo que requer tratamento especial.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/fornecedores")
public class TblFornecedorController {

    final TblFornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<TblFornecedorDTO>> buscaFornecedor(){
        List<TblFornecedorDTO> lista = fornecedorService.buscaFornecedor();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblFornecedor criaFonecedor(@RequestBody TblFornecedor fornecedor){
        return fornecedorService.criaForncedor(fornecedor);
    }

    @DeleteMapping(value = "/{idFornecedor}")
    public ResponseEntity<TblFornecedor> deletarFornecedor(@PathVariable("idFornecedor") Integer idFornecedor){
        fornecedorService.deletaFornecedor(idFornecedor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @PutMapping("/{idFornecedor}")
//<<<<<<< HEAD
//    public ResponseEntity<Integer> atualizarFornecedor( @RequestBody TblFornecedor fornecedor){
//=======
//    public ResponseEntity<Integer> atualizarFornecedor(@PathVariable(name="id") Integer id, @RequestBody TblFornecedor fornecedor){
//        fornecedor.setIdFornecedor(id);
//>>>>>>> 10007257c96e1efd68913e70126d6a0b5949d34d
//        TblFornecedor tblFornecedor = fornecedorService.atualizaFornecedor(fornecedor);
//        return ResponseEntity.status(HttpStatus.OK).body(tblFornecedor.getIdFornecedor());
//    }
}
