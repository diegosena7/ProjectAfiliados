package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblClientesDTO;
import br.com.afiliados.afiliadosEcomm.model.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.service.TblClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Nesta classe estamos injetando a dependencia no objeto fornecedorService através da anotação @RequiredArgsConstructor
 * esta anotação gera um construtor com 1 parâmetro para cada campo que requer tratamento especial.
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
}
