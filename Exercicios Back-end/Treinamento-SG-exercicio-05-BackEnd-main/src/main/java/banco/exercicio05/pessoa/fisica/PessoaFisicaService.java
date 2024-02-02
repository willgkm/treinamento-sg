package banco.exercicio05.pessoa.fisica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;

    public List<PessoaFisica> getAll() {
        return repository.findAll();
    }

    public PessoaFisica getById(Long id) {
        return repository.findById(id).get();
    }

    public PessoaFisica criarPessoaFisica(PessoaFisica novaPessoaFisica) {
        repository.save(novaPessoaFisica);
        return novaPessoaFisica;
    }

    public PessoaFisica alterarPessoaFisica(PessoaFisica modificado){
        if (!repository.findById(modificado.getId()).isPresent()) {
            throw new RuntimeException("Usuario não existe");
        }
        repository.save(modificado);
        return modificado;
    }

    public void deletePessoaFisicaById(Long id) {
        repository.deleteById(id);
    }


}

