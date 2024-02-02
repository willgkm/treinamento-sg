package Exercicio03.Sg.servico;

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
@RequestMapping("/servicos")
public class ServicoController {
    
    @Autowired 
    private ServicoService service;

    @GetMapping
    private List<Servico> getServicos(){
        return this.service.listarServicos();
    }

    @GetMapping("/{id}")
    private Servico getServicoPeloId(@PathVariable long id){
        return this.service.consultarServiço(id);
    }

    @PostMapping("/cadastrar")
    private Servico postServico(@RequestBody Servico novoServico){
        return this.service.CadastrarServiço(novoServico);
    }   

    @DeleteMapping("/excluir/{id}")
    private String deleteServico(@PathVariable Long id){
        return this.service.deletarServiço(id);
    }
    
    
}
