package banco.exercicio05.pessoa.fisica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @GetMapping
    private List<PessoaFisica> getAllPessoasFisica() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private PessoaFisica getPessoaFisicaById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    private PessoaFisica createNewPessoaFisica(@RequestBody PessoaFisica novaPessoa) {
        return service.criarPessoaFisica(novaPessoa);
    }

    @PutMapping
    private PessoaFisica altualizarPessoaFisica(@RequestBody PessoaFisica modificado) {
        return service.alterarPessoaFisica(modificado);
    }

    @DeleteMapping("/{id}")
    private void deletePessoaFisica(@PathVariable("id") Long id){
        service.deletePessoaFisicaById(id);
    }
}
