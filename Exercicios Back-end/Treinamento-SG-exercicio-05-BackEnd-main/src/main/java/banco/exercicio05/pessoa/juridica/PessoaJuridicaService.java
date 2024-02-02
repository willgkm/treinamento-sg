package banco.exercicio05.pessoa.juridica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    public List<PessoaJuridica> getAll() {
        return repository.findAll();
    }

    public PessoaJuridica getById(Long id) {
        return repository.findById(id).get();
    }

    public PessoaJuridica criarPessoaJuridica(PessoaJuridica novaPessoaJuridica) {
        repository.save(novaPessoaJuridica);
        return novaPessoaJuridica;
    }

}
