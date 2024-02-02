package Exercicio03.Sg.funcionario;

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
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService serviceFuncionario;
    
    @GetMapping
    private List<Funcionario> getFuncionarios(){
        return this.serviceFuncionario.listarFuncionarios();
    }

    @GetMapping("/{id}")
    private Funcionario getFuncionarioPeloId(@PathVariable long id){
        return this.serviceFuncionario.pesquisarFuncionario(id);
    }

    @PostMapping("/cadastrar")
    private Funcionario postFuncionario(@RequestBody Funcionario novoFuncionario){
        return this.serviceFuncionario.cadastrarFuncionario(novoFuncionario);
    }   

    @DeleteMapping("/excluir/{id}")
    private String deleteFuncionario(@PathVariable Long id){
        return this.serviceFuncionario.deletarFuncionario(id);
    }
    
}
