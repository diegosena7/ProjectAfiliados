package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.exceptions.ObjectNotFoundException;
import br.com.afiliados.afiliadosEcomm.model.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import br.com.afiliados.afiliadosEcomm.model.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.repositories.TblFornecedorRepository;
import br.com.afiliados.afiliadosEcomm.service.TblFornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo.
 * E estamos trabalhando com o tipo Page no método de busca para poder  ter uma ordenação de itens por páginas, onde a
 * qtidade de itens por página é de 20 itens.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/fornecedores")
public class TblFornecedorController {

    final TblFornecedorService fornecedorService;
    final TblFornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<Page<TblFornecedor>> buscaFornecedor(Pageable pageable) {
        Page<TblFornecedor> lista = fornecedorRepository.findAll(pageable);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("{idFornecedor}")
    public ResponseEntity buscaFornecedorPorId(@PathVariable("idFornecedor") Integer idFornecedor) {
        return ResponseEntity.ok().body(fornecedorService.bucarFornecedorPorId(idFornecedor));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblFornecedor criaFonecedor(@RequestBody TblFornecedor fornecedor) {
        return fornecedorService.criaForncedor(fornecedor);
    }

    @DeleteMapping(value = "/{idFornecedor}")
    public ResponseEntity<TblFornecedor> deletarFornecedor(@PathVariable("idFornecedor") Integer idFornecedor) {
        fornecedorService.deletaFornecedor(idFornecedor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{idFornecedor}")
    public ResponseEntity atualizarFornecedor(@PathVariable("idFornecedor") Integer idFornecedor, @RequestBody TblFornecedor fornecedor){
        return fornecedorRepository.findById(idFornecedor).map(
                dados -> {
                    dados.setAtivo(fornecedor.getAtivo());
                    TblFornecedor tblFornecedor = fornecedorRepository.save(dados);
                    return ResponseEntity.ok().body(tblFornecedor);
                }).orElseThrow(() -> new ObjectNotFoundException("Id: " + idFornecedor + " não encontrado para atualizar fornecedor." + " tipo: "
                + TblAfiliados.class.getName()));
    }
}
