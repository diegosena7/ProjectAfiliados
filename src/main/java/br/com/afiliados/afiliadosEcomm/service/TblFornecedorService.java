package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.repositories.TblFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TblFornecedorService {

    @Autowired
    private TblFornecedorRepository fornecedorRepository;

    public List<TblFornecedorDTO> buscaFornecedor(){
        List<TblFornecedor> lista = fornecedorRepository.findAll();
        //Transforma o objeto Entity em DTO com lambda
        return lista.stream().map(forn -> new TblFornecedorDTO(forn)).collect(Collectors.toList());
    }
}