package Exercicio03.Sg.veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class veiculoService {
    
    @Autowired
    private VeiculoRepository repositoryVeiculo;

    public List<Veiculo> listarVeiculos(){
        return repositoryVeiculo.findAll();
    }

    public Veiculo pesquisarVeiculo(Long id){
        return repositoryVeiculo.findById(id).get();
    }

    public Veiculo cadastrarVeiculo(Veiculo novoVeiculo){
        repositoryVeiculo.save(novoVeiculo);
        return novoVeiculo;
    }

    public String deletarVeiculo(long id){
        String mensagem = ("Veiculo : " + repositoryVeiculo.findById(id).get().getModelo() + 
                            " Placa :" + repositoryVeiculo.findById(id).get().getPlaca()  + "\nEXCLUIDO !!!!!");
        repositoryVeiculo.deleteById(id);
        return mensagem;
    }
}
