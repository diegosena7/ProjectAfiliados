package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblAfiliadosDTO;
import br.com.afiliados.afiliadosEcomm.model.dto.TblClientesDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import br.com.afiliados.afiliadosEcomm.model.entities.TblProdutos;
import br.com.afiliados.afiliadosEcomm.repositories.TblAfiliadosRepository;
import br.com.afiliados.afiliadosEcomm.service.TblAfiliadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/afiliados")
public class TblAfiliadosController {

    final TblAfiliadosService afiliadosService;
    final TblAfiliadosRepository afiliadosRepository;

    @GetMapping
    public ResponseEntity<List<TblAfiliadosDTO>> buscarAfiliados() {
        List<TblAfiliadosDTO> afiliadosDTOS = afiliadosService.buscarAfiliados();
        return ResponseEntity.ok().body(afiliadosDTOS);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblAfiliados inserirAfiliados(@RequestBody TblAfiliados tblAfiliados) {
        return afiliadosService.inserirAfiliados(tblAfiliados);
    }

    @DeleteMapping(value = "/{idAfiliado}")
    public ResponseEntity<TblAfiliados> deleteAfiliado(@PathVariable("idAfiliado") Integer idAfiliado){
        afiliadosService.deleteCliente(idAfiliado);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{idAfiliado}")
    public ResponseEntity<Integer> atualizarAfiliado(@PathVariable("idAfiliado") Integer idAfiliado, @RequestBody TblAfiliados afiliados){
       afiliados.setIdAfiliado(idAfiliado);
       TblAfiliados afiliadoReturn = afiliadosService.atualizarAfiliado(afiliados);
       return ResponseEntity.status(HttpStatus.OK).body(afiliadoReturn.getIdAfiliado());
    }
}
