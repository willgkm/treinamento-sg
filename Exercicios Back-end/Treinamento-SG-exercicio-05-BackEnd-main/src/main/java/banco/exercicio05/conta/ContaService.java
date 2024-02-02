package banco.exercicio05.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> listarTodos() {
        return repository.findAll();
    }

    public Conta buscarContaPorId(Long id) {
        return repository.getById(id);
    }


}
