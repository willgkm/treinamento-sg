package exercicio1.treinamentoSg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercicio1.treinamentoSg.domain.Funcionario;
import exercicio1.treinamentoSg.repository.FuncionarioRepository;
import exercicio1.treinamentoSg.repository.PontoRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    @Autowired PontoRepository pontoRepository;

    public List<Funcionario> listarFuncionarios(){
        return repository.findAll();
    }

    public Funcionario pegarUmFuncionario(Long id) {
        return repository.findById(id).get() ;
    }

    public Funcionario adicionarFuncionario(Funcionario novoFuncionario) {
        novoFuncionario.setBloqueio(false);
        repository.save(novoFuncionario);
        return novoFuncionario;
    }

    public Funcionario bloquearFuncionario(Long id) {
        repository.MudarStatusFuncicionario(true,id);

        return repository.findById(id).get();
    }
    
    public Funcionario desbloquearFuncionario(Long id) {
        pontoRepository.conferirPontosAtrasados(id);
        repository.MudarStatusFuncicionario(false, id);
    return repository.findById(id).get();
    }
    


}
