package banco.exercicio05.conta.poupanca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-poupancas")
public class ContaPoupancaController {

    @Autowired
    private ContaPoupancaService service;

    @GetMapping
    private List<ContaPoupanca> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    private ContaPoupanca getAll(@PathVariable Long id) {
        return service.buscarContaPoupanca(id);
    }

    @PostMapping("/cadastrar")
    private ResponseEntity<String> cadastrarContaPoupanca(@RequestBody ContaPoupanca novaContaPoupanca) {
        return service.criarContaPoupanca(novaContaPoupanca);
    }

    @PutMapping("/alterar")
    private ContaPoupanca alterarContaPoupanca(@RequestBody ContaPoupanca alterarContaPoupanca) {
        return service.alterarDadosContaPoupanca(alterarContaPoupanca);
    }

    @DeleteMapping("/desativar/{id}")
    private void desativarContaPoupanca(@PathVariable Long id) {
        service.desativarContaPoupanca(id);
    }

}
