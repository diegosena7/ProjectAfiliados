package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.model.dto.TblAfiliadosDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblAfiliados;
import br.com.afiliados.afiliadosEcomm.repositories.TblAfiliadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TblAfiliadosService {

    final private TblAfiliadosRepository afiliadosRepository;


    /**
     * Método responsável por buscar os afiliados, através do método findAll da Classe TblAfiliadosRepository
     * @return litsa de afiliados
     */
    public List<TblAfiliadosDTO> buscarAfiliados(){
        List<TblAfiliados> afiliados = afiliadosRepository.findAll();
        return afiliados.stream().map(afiliado -> new TblAfiliadosDTO(afiliado)).collect(Collectors.toList());
    }
}
