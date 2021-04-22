package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.exceptions.ObjectNotFoundException;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.repositories.TblAfiliadosRepository;
import br.com.afiliados.afiliadosEcomm.service.TblAfiliadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo.
 * E estamos trabalhando com o tipo Page no método de busca para poder  ter uma ordenação de itens por páginas, onde a
 * qtidade de itens por página é de 20 itens.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/afiliados")
public class TblAfiliadosController {

    final TblAfiliadosService afiliadosService;
    final TblAfiliadosRepository afiliadosRepository;

    @GetMapping
    public ResponseEntity<Page<TblAfiliados>> buscarAfiliados(Pageable pageable) {
        Page<TblAfiliados> afiliadosDTOS = afiliadosRepository.findAll(pageable);
        return ResponseEntity.ok().body(afiliadosDTOS);
    }

    @GetMapping("{idAfiliado}")
    public ResponseEntity buscarAfiliadoPorId(@PathVariable("idAfiliado") Integer idAfiliado) {
        return ResponseEntity.ok().body(afiliadosService.buscarAfiliadoPorId(idAfiliado));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblAfiliados inserirAfiliados(@RequestBody TblAfiliados tblAfiliados) {
        return afiliadosService.inserirAfiliados(tblAfiliados);
    }

    @DeleteMapping(value = "/{idAfiliado}")
    public ResponseEntity<TblAfiliados> deleteAfiliado(@PathVariable("idAfiliado") Integer idAfiliado) {
        afiliadosService.deletarAfiliado(idAfiliado);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{idAfiliado}")
    public ResponseEntity atualizarAfiliado(@PathVariable("idAfiliado") Integer idAfiliado, @RequestBody @Valid TblAfiliados afiliados) {
        return afiliadosRepository.findById(idAfiliado).map(
                dados -> {
                    dados.setNomeAfiliado(afiliados.getNomeAfiliado());
                    dados.setAtivo(afiliados.getAtivo());
                    TblAfiliados tblAfiliados = afiliadosRepository.save(dados);
                    return ResponseEntity.ok().body(tblAfiliados);
                }).orElseThrow(() -> new ObjectNotFoundException("Id: " + idAfiliado + " não encontrado para atualizar usuário." + " tipo: "
                + TblAfiliados.class.getName()));
    }
}
