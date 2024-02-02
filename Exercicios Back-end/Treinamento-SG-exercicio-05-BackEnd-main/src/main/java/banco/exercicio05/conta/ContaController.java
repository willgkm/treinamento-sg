package banco.exercicio05.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    private List<Conta> getAll() {
        return service.listarTodos();
    }

    private Conta getById(@PathVariable("id") Long id) {
        return service.buscarContaPorId(id);
    }


}

