package Exercicio03.Sg.orcamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    
    @Autowired
    private OrcamentoService service;
    
    @GetMapping
    private List<Orcamento> getOrcamentos(){
        return this.service.listarOrcamentos();
    }

    @GetMapping("/{id}")
    private Orcamento getOrcamentoPeloId(@PathVariable long id){
        return this.service.pesquisarOrcamento(id);
    }

    @PostMapping("/cadastrar")
    private Orcamento postOrcamento(@RequestBody Orcamento novoOrcamento){
        return this.service.cadastrarOrcamento(novoOrcamento);
    }   

    @DeleteMapping("/excluir/{id}")
    private String deleteOrcamento(@PathVariable Long id){
        return this.service.deletarOrcamento(id);
    }
}
