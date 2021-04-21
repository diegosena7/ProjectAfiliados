package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblClientesDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import br.com.afiliados.afiliadosEcomm.service.TblClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class TblClientesController {

    final TblClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<TblClientesDTO>> buscaCliente(){
        List<TblClientesDTO> lista = clientesService.buscaClientes();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("{idCliente}")
    public ResponseEntity buscarAfiliadoPorId(@PathVariable("idCliente") Integer idCliente) {
        return ResponseEntity.ok().body(clientesService.buscarClientePorId(idCliente));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TblClientes inseriCliente(@RequestBody TblClientes tblClientes){
        return clientesService.inseriCliente(tblClientes);
    }

    @DeleteMapping(value = "/{idCliente}")
    public ResponseEntity<TblClientes> deleteCliente(@PathVariable("idCliente") Integer idCliente){
        clientesService.deleteCliente(idCliente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Integer> atualizarCliente(@PathVariable("idCliente") Integer idCliente, @RequestBody TblClientes clientes){
        clientes.setIdCliente(idCliente);
        TblClientes clinteAtualizado = clientesService.atualizaCliente(clientes);
        return ResponseEntity.status(HttpStatus.OK).body(clinteAtualizado.getIdCliente());
    }
}
