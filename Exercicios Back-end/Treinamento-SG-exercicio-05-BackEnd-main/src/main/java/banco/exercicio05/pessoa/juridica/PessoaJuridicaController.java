package banco.exercicio05.pessoa.juridica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @GetMapping
    private List<PessoaJuridica> getAllPessoasJuriPessoaJuridica() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private PessoaJuridica getPessoaJuridicaById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    private PessoaJuridica createNewPessoaJuridica(@RequestBody PessoaJuridica novaPessoa) {
        return service.criarPessoaJuridica(novaPessoa);
    }
}
