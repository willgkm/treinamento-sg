package exercicio1.treinamentoSg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exercicio1.treinamentoSg.domain.Ponto;
import exercicio1.treinamentoSg.service.PontoService;

@RestController
@RequestMapping("/ponto")
public class PontoController {
    
    @Autowired
    private PontoService service;

    @GetMapping
    private List<Ponto> getPontos(){
        return this.service.listarPonto();
    }

    @GetMapping("/um-ponto-especifico/{id}")
    private Ponto getPontoEspecifico(@PathVariable("id") Long id ){
        return this.service.pegarUmPonto(id);
    }
    
    @GetMapping("/todos-pontos-de-um-funcionario/{id}")
    private List<Ponto> getPontosPorID(@PathVariable("id") Long id){
        return this.service.pegarPontosDeUmFuncionario(id);
    }
    
    @GetMapping("/todos-pontos-de-um-funcionario-no-dia/{id}")
    private List<Ponto> getPontosDoFuncionarioDia(@PathVariable("id") Long id){
        return this.service.ListaPontosDoFuncionarioDia(id);
    }

    @GetMapping("/atrasos-de-um-funcionario-na-semana/{id}")
    private List<Ponto> getPontosDoFuncionarioSemana(@PathVariable("id") Long id){
        return this.service.AtrasosDoFuncionarioNaSemana(id);
    }

    @PostMapping("/cadastrar")
    private String CadastrarPonto(@RequestBody Ponto novoPonto){
        return this.service.criarPonto(novoPonto);
    }

}
