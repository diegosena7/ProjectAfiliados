package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.service.TblFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class TblFornecedorController {

    @Autowired
    TblFornecedorService fornecedorService;

    @GetMapping("/busca")
    public ResponseEntity<List<TblFornecedorDTO>> buscaFornecedor(){
        List<TblFornecedorDTO> lista = fornecedorService.buscaFornecedor();
        return ResponseEntity.ok().body(lista);
    }
}
