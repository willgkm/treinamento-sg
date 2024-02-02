package banco.exercicio05.conta.fisica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-fisicas")
public class ContaFisicaController {

    @Autowired
    private ContaFisicaService service;

    @GetMapping
    private List<ContaFisica> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    private ContaFisica getAll(@PathVariable Long id) {
        return service.buscarContaFisica(id);
    }

    @PostMapping("/cadastrar")
    private ContaFisica cadastrarContaFisica(@RequestBody ContaFisica novaContaFisica) {
        return service.criarContaFisica(novaContaFisica);
    }

    @PutMapping("/alterar")
    private ContaFisica alterarContaFisica(@RequestBody ContaFisica alterarContaFisica) {
        return service.alterarDadosContaFisica(alterarContaFisica);
    }

    @DeleteMapping("/desativar/{id}")
    private void desativarContaFisica(@PathVariable Long id) {
        service.desativarContaFisica(id);
    }

}
