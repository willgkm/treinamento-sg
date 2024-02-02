package Exercicio03.Sg.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Cliente pesquisarCliente(Long id){
        return repository.findById(id).get();
    }

    public Cliente cadastrarCliente(Cliente novoCliente){
        repository.save(novoCliente);
        return novoCliente;
    }

    public String deletarCliente(long id){
        String mensagem = ("cliente : " + repository.findById(id).get().getNomeCliente() + "\nEXCLUIDO !!!!!");
        repository.deleteById(id);
        return mensagem;
    }


}
