package banco.exercicio05.conta.poupanca;

import banco.exercicio05.movimentacao.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaPoupancaService {

    @Autowired
    private ContaPoupancaRepository repository;

    @Autowired
    private MovimentacaoService serviceMovimentacao;

    public List<ContaPoupanca> listarTodos() {
        return repository.findAll();
    }

    public ContaPoupanca buscarContaPoupanca(Long id) {
        return repository.findById(id).get();
    }

    public ResponseEntity<String> criarContaPoupanca(ContaPoupanca novaContaPoupanca) {

        if (repository.verificarExistenciaDeConta(novaContaPoupanca.getClienteFisico().getId()) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O cliente já possuiu uma conta criada");
        }

        double limiteContaPoupanca = 0;
        serviceMovimentacao.criarMovimentacao(novaContaPoupanca, limiteContaPoupanca);


        novaContaPoupanca = repository.save(novaContaPoupanca);

        return ResponseEntity.status(HttpStatus.CREATED).body("Conta fisica criada com sucesso");
    }

    public void desativarContaPoupanca(Long id) {
        repository.deleteById(id);
    }

    public ContaPoupanca alterarDadosContaPoupanca(ContaPoupanca modificar) {
        modificar = repository.save(modificar);
        return modificar;
    }
    
}
