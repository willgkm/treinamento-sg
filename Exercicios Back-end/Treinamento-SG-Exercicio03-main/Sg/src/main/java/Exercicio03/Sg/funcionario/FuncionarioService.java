package Exercicio03.Sg.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarFuncionarios(){
        return repository.findAll();
    }

    public Funcionario pesquisarFuncionario(Long id){
        return repository.findById(id).get();
    }

    public Funcionario cadastrarFuncionario(Funcionario novoFuncionario){
        repository.save(novoFuncionario);
        return novoFuncionario;
    }

    public String deletarFuncionario(long id){
        String mensagem = ("Funcionario : " + repository.findById(id).get().getNomeFuncionario() + "\nEXCLUIDO !!!!!");
        repository.deleteById(id);
        return mensagem;
    }

    
}
