package banco.exercicio05.conta.juridica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-juridicas")
public class ContaJuridicaController {

    @Autowired
    private ContaJuridicaService service;

    @GetMapping
    private List<ContaJuridica> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    private ContaJuridica getAll(@PathVariable Long id) {
        return service.buscarContaJuridica(id);
    }

    @PostMapping("/cadastrar")
    private ResponseEntity<String> cadastrarContaJuridica(@RequestBody ContaJuridica novaContaJuridica) {
        return service.criarContaJuridica(novaContaJuridica);
    }

    @PutMapping("/alterar")
    private ContaJuridica alterarContaJuridica(@RequestBody ContaJuridica alterarContaJuridica) {
        return service.alterarDadosContaJuridica(alterarContaJuridica);
    }

    @DeleteMapping("/desativar/{id}")
    private void desativarContaJuridica(@PathVariable Long id) {
        service.desativarContaJuridica(id);
    }

}
