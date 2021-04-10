package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.dto.TblFornecedorDTO;
import br.com.afiliados.afiliadosEcomm.entities.TblFornecedor;
import br.com.afiliados.afiliadosEcomm.repositories.TblFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TblFornecedorService {

    @Autowired
    private TblFornecedorRepository fornecedorRepository;

    //Retorna uma lista de fornecedores
    public List<TblFornecedorDTO> buscaFornecedor(){
        List<TblFornecedor> lista = fornecedorRepository.findAll();
        //Transforma o objeto Entity em DTO com lambda, mapeia os dados e transforma em lista
        return lista.stream().map(forn -> new TblFornecedorDTO(forn)).collect(Collectors.toList());
    }

    //Insere no bd um fornecedor
   public TblFornecedor criaForncedor(TblFornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
   }

   //Deleta um fornecedor
   public void deletaFornecedor(Integer idFornecedor){
        fornecedorRepository.deleteById(idFornecedor);
   }

   //Atualiza um fornecedor
//    public TblFornecedorDTO atualizaFornecedor(Integer idFornecedor){
//        TblFornecedor tblFornecedor = fornecedorRepository.getOne(idFornecedor);
//        tblFornecedor.setIdFornecedor(idFornecedor);
//        tblFornecedor = fornecedorRepository.save(tblFornecedor);
//        return new TblFornecedorDTO(tblFornecedor);
//    }

    //Atualiza um fornecedor
    public TblFornecedor atualizaFornecedor(TblFornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }
}