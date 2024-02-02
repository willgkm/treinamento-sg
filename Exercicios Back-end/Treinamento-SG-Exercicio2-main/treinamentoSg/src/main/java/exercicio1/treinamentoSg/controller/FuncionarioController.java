package exercicio1.treinamentoSg.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exercicio1.treinamentoSg.domain.Funcionario;
import exercicio1.treinamentoSg.service.FuncionarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired 
    private FuncionarioService serviceFuncionario;

    @GetMapping
    public List<Funcionario> getFuncionarios() {
        return this.serviceFuncionario.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionariosPeloID(@PathVariable("id") Long id){
        return this.serviceFuncionario.pegarUmFuncionario(id);
    }

    @PostMapping("/cadastrar")
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario nome ){
        return serviceFuncionario.adicionarFuncionario(nome);
    }
    
    @PutMapping("/bloquear/{id}")
    public Funcionario bloquearPorID(@PathVariable("id")Long id){
        serviceFuncionario.bloquearFuncionario(id);
        return this.serviceFuncionario.pegarUmFuncionario(id);
    }
    
    @PutMapping("/desbloquear/{id}")
    public Funcionario desbloquearPorID(@PathVariable("id")Long id){
            serviceFuncionario.desbloquearFuncionario(id);
            return this.serviceFuncionario.pegarUmFuncionario(id);
    }
    
}
