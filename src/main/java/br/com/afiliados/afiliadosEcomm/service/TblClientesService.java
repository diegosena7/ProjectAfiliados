package br.com.afiliados.afiliadosEcomm.service;

import br.com.afiliados.afiliadosEcomm.model.dto.TblClientesDTO;
import br.com.afiliados.afiliadosEcomm.model.entities.TblClientes;
import br.com.afiliados.afiliadosEcomm.repositories.TblClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TblClientesService {

    final private TblClientesRepository clientesRepository;

    /**
     * Método responsável por retornar uma lista de fornecedores
     * Usamos o stream, map e collect para transformar o objeto Entity
     * em DTO com lambda, mapeia os dados e transforma em lista
     * @return
     */
    public List<TblClientesDTO> buscaClientes(){
        List<TblClientes> lista = clientesRepository.findAll();
        return lista.stream().map(cliente -> new TblClientesDTO(cliente)).collect(Collectors.toList());
    }

    /**
     * Método responsável por inserir um cliente na base de dados
     * @param tblClientes
     * @return
     */
    public TblClientes inseriCliente(TblClientes tblClientes){
        return clientesRepository.save(tblClientes);
    }

    /**
     * Método responsável por excluir um cliente do BD através do id
     * @param idCliente
     */
    public void deleteCliente(Integer idCliente){
        clientesRepository.deleteById(idCliente);
    }
}
