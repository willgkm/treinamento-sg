package Exercicio03.Sg.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository repository;

    public List<Servico> listarServicos(){
        return repository.findAll();
    }

    public Servico consultarServiço(Long id){
        return repository.findById(id).get();
    }

    public Servico CadastrarServiço(Servico novoServico){
        repository.save(novoServico);
        return novoServico;
    }

    public String deletarServiço(long id){
        String mensagem = ("serviço : " + repository.findById(id).get().getNome() +"\nExcluido!!!" );
        repository.deleteById(id);
        return mensagem;

    }
}
