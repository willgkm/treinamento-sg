package Exercicio03.Sg.veiculo;

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
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private veiculoService serviceVeiculo;
    
    @GetMapping
    private List<Veiculo> getVeiculos(){
        return this.serviceVeiculo.listarVeiculos();
    }

    @GetMapping("/{id}")
    private Veiculo getVeiculoPeloId(@PathVariable long id){
        return this.serviceVeiculo.pesquisarVeiculo(id);
    }

    @PostMapping("/cadastrar")
    private Veiculo postVeiculo(@RequestBody Veiculo novoVeiculo){
        return this.serviceVeiculo.cadastrarVeiculo(novoVeiculo);
    }   

    @DeleteMapping("/excluir/{id}")
    private String deleteVeiculo(@PathVariable Long id){
        return this.serviceVeiculo.deletarVeiculo(id);
    }
    
}
