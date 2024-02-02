package banco.exercicio05.conta.fisica;

import banco.exercicio05.movimentacao.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaFisicaService {

    @Autowired
    private ContaFisicaRepository repository;

    @Autowired
    private MovimentacaoService serviceMovimentacao;

    public List<ContaFisica> listarTodos() {
        return repository.findAll();
    }

    public ContaFisica buscarContaFisica(Long id) {
        return repository.findById(id).get();
    }

    public ContaFisica criarContaFisica(ContaFisica novaContaFisica) {

        if (repository.verificarExistenciaDeConta(novaContaFisica.getClienteFisico().getId()) > 0) {
            throw new RuntimeException("O cliente já possuiu uma conta fisica!!!!");
        }

        double limiteContaFisica = -500L;
        serviceMovimentacao.criarMovimentacao(novaContaFisica, limiteContaFisica);

        novaContaFisica = repository.save(novaContaFisica);

        return novaContaFisica;
    }

    public void desativarContaFisica(Long id) {
        repository.deleteById(id);
    }

    public ContaFisica alterarDadosContaFisica(ContaFisica modificar) {
        modificar = repository.save(modificar);
        return modificar;
    }

}