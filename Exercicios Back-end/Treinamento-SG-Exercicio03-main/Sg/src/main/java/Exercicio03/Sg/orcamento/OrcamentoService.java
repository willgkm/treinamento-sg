package Exercicio03.Sg.orcamento;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    public List<Orcamento> listarOrcamentos(){
        return repository.findAll();
    }

    public Orcamento pesquisarOrcamento(Long id){
        return repository.findById(id).get();
    }

    @Transactional
    public Orcamento cadastrarOrcamento(Orcamento novoOrcamento){
        
        int diasTotaisDeServico = 0;
        for (int i = 0; i < novoOrcamento.getItens().size() ; i++) {
            diasTotaisDeServico = diasTotaisDeServico + novoOrcamento.getItens().get(i).getTempoDeServico();
        }
        novoOrcamento.setDiasTotaisDeServico(diasTotaisDeServico);
        repository.save(novoOrcamento);
        double valorTotal =  repository.somaValoresDosServicosNoOrcamento(novoOrcamento.getId());
        Long id = novoOrcamento.getId();
        repository.alterarValorTotalNaTabela(valorTotal, id);

        return novoOrcamento;
    }

    public String deletarOrcamento(long id){
        String mensagem = ("Orcamento : " + repository.findById(id).get() + "\nEXCLUIDO !!!!!");
        repository.deleteById(id);
        return mensagem;
    }

    public Double getValorTotalOrcamento(Long id){
        double valorTotal = repository.somaValoresDosServicosNoOrcamento(id);
        return valorTotal;
    }




}

