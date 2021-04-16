package br.com.afiliados.afiliadosEcomm.controller;

import br.com.afiliados.afiliadosEcomm.model.dto.TblAfiliadosDTO;
import br.com.afiliados.afiliadosEcomm.model.dto.TblClientesDTO;
import br.com.afiliados.afiliadosEcomm.service.TblAfiliadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/afiliados")
public class TblAfiliadosController {

    final TblAfiliadosService afiliadosService;

    @GetMapping
    public ResponseEntity<List<TblAfiliadosDTO>> buscarAfiliados(){
        List<TblAfiliadosDTO> afiliadosDTOS = afiliadosService.buscarAfiliados();
        return ResponseEntity.ok().body(afiliadosDTOS);
    }
}
