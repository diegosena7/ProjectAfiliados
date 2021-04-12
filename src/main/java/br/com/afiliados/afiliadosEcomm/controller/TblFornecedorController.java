package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.service.TblFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class TblFornecedorController {

    @Autowired
    TblFornecedorService fornecedorService;

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

    @PutMapping("/{idFornecedor}")
    public ResponseEntity<Integer> atualizarFornecedor(@PathVariable(name="id") Integer id, @RequestBody TblFornecedor fornecedor){
        fornecedor.setIdFornecedor(id);
        TblFornecedor tblFornecedor = fornecedorService.atualizaFornecedor(fornecedor);
        return ResponseEntity.status(HttpStatus.OK).body(tblFornecedor.getIdFornecedor());
    }
}
