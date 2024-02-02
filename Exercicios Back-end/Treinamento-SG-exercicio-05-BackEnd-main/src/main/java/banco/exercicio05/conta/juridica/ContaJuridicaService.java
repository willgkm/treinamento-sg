package banco.exercicio05.conta.juridica;

import banco.exercicio05.movimentacao.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaJuridicaService {

    @Autowired
    private ContaJuridicaRepository repository;

    @Autowired
    private MovimentacaoService serviceMovimentacao;

    public List<ContaJuridica> listarTodos() {
        return repository.findAll();
    }

    public ContaJuridica buscarContaJuridica(Long id) {
        return repository.findById(id).get();
    }

    public ResponseEntity<String> criarContaJuridica(ContaJuridica novaContaJuridica) {

        if (repository.verificarExistenciaDeConta(novaContaJuridica.getClienteJuridico().getId()) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O cliente já possuiu uma conta criada");
        }

        double limiteContaFisica = -2000L;
        serviceMovimentacao.criarMovimentacao(novaContaJuridica, limiteContaFisica);

        novaContaJuridica = repository.save(novaContaJuridica);

        return ResponseEntity.status(HttpStatus.CREATED).body("Conta juridica criada com sucesso");
    }

    public void desativarContaJuridica(Long id) {
        repository.deleteById(id);
    }

    public ContaJuridica alterarDadosContaJuridica(ContaJuridica modificar) {

        modificar = repository.save(modificar);
        return modificar;
    }

}
