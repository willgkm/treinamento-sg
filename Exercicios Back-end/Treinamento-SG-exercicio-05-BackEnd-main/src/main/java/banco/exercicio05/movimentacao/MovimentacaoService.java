package banco.exercicio05.movimentacao;

import banco.exercicio05.conta.Conta;
import banco.exercicio05.registro.Registro;
import banco.exercicio05.registro.RegistroRepository;
import banco.exercicio05.registro.dto.ExtratoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private RegistroRepository registroRepository;

    public List<Movimentacao> listarTodos() {
        return repository.findAll();
    }

    public Movimentacao buscarMovimentacao(Long id) {
        return repository.findById(id).get();
    }

    public Movimentacao buscarMovimentacaoPorConta (Long id){ return repository.buscarMovimentacaoPorConta(id);}

    public Movimentacao criarMovimentacao(Conta conta, double limiteCredito) {

        Movimentacao novaMovimentacao = new Movimentacao();
        novaMovimentacao.setSaldo(0);
        novaMovimentacao.setLimiteCredito(limiteCredito);
        novaMovimentacao.setConta(conta);
        repository.save(novaMovimentacao);
        return novaMovimentacao;
    }

    public Movimentacao realizarDeposito(Long id, Double valorDeposito) {

        Movimentacao movimentacaoAtual = repository.buscarMovimentacaoPorConta(id);

        Registro ultimoRegistro = registroRepository.ultimoRegistro(id);

        if (registroRepository.listaDeRegistrosDoDia(id).isEmpty() && Objects.nonNull(ultimoRegistro) && ultimoRegistro.getSaldoPosOperacao() < 0){
            calcularJurosDaConta(movimentacaoAtual,ultimoRegistro);
        }

        movimentacaoAtual.setSaldo(movimentacaoAtual.getSaldo() + (valorDeposito));

        descontarJuros(movimentacaoAtual);

        int operacaoDeposito = 1;
        gerarRegistro(movimentacaoAtual, null, valorDeposito, operacaoDeposito);

        repository.save(movimentacaoAtual);
        return movimentacaoAtual;
    }

    public Movimentacao realizarSaque(Long id, Double valorSaque) {

        Movimentacao movimentacaoAtual = repository.buscarMovimentacaoPorConta(id);

        if ((movimentacaoAtual.getSaldo() - valorSaque) < movimentacaoAtual.getLimiteCredito()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        Registro ultimoRegistro = registroRepository.ultimoRegistro(id);

        if (registroRepository.listaDeRegistrosDoDia(id).isEmpty() && Objects.nonNull(ultimoRegistro) && ultimoRegistro.getSaldoPosOperacao() < 0){
            calcularJurosDaConta(movimentacaoAtual,ultimoRegistro);
        }

        double valorSaqueNegativo = valorSaque * (-1);
        movimentacaoAtual.setSaldo(movimentacaoAtual.getSaldo() + valorSaqueNegativo);

        int operacaoSaque = 2;
        gerarRegistro(movimentacaoAtual, null, valorSaqueNegativo, operacaoSaque);

        return movimentacaoAtual;
    }

    public Movimentacao realizarTransferencia(Long idEnviar, Long idReceber, double valorTransferencia) {

        Movimentacao movimentacaoEnvia = repository.buscarMovimentacaoPorConta(idEnviar);
        Movimentacao movimentacaoReceber = repository.buscarMovimentacaoPorConta(idReceber);

        Registro ultimoRegistroEnviar = registroRepository.ultimoRegistro(idEnviar);

        if (registroRepository.listaDeRegistrosDoDia(idEnviar).isEmpty() && Objects.nonNull(ultimoRegistroEnviar) && ultimoRegistroEnviar.getSaldoPosOperacao() < 0){
            calcularJurosDaConta(movimentacaoEnvia,ultimoRegistroEnviar);
        }

        Registro ultimoRegistroReceber = registroRepository.ultimoRegistro(idReceber);

        if (registroRepository.listaDeRegistrosDoDia(idReceber).isEmpty() && Objects.nonNull(ultimoRegistroReceber) && ultimoRegistroReceber.getSaldoPosOperacao() < 0){
            calcularJurosDaConta(movimentacaoReceber,ultimoRegistroReceber);
        }


        if ((movimentacaoEnvia.getSaldo() - valorTransferencia) < movimentacaoEnvia.getLimiteCredito()) {
            throw new RuntimeException("Saldo insuficiente para realizar transferencia");
        }

        double valorTransferenciaNegativo = valorTransferencia * (-1);
        movimentacaoEnvia.setSaldo(movimentacaoEnvia.getSaldo() + valorTransferenciaNegativo);
        movimentacaoReceber.setSaldo(movimentacaoReceber.getSaldo() + valorTransferencia);

        descontarJuros(movimentacaoReceber);

        gerarRegistro(movimentacaoEnvia, movimentacaoReceber, valorTransferenciaNegativo, 3);
        gerarRegistro(movimentacaoReceber, movimentacaoReceber, valorTransferencia, 4);

        return movimentacaoEnvia ;
    }

    public void calcularJurosDaConta(Movimentacao movimentacao, Registro ultimoRegistro) {

        LocalDateTime dataDaUltimaOperacao = ultimoRegistro.getDataOperacao();
        int diasDeCobrança = (LocalDateTime.now().getDayOfYear() - dataDaUltimaOperacao.getDayOfYear());

        double juros =  (diasDeCobrança * (ultimoRegistro.getSaldoPosOperacao() * movimentacao.getTaxaJuras())) * (-1);
        movimentacao.setJurosDaConta(movimentacao.getJurosDaConta() + juros);

    }

    public void gerarRegistro(Movimentacao enviar, Movimentacao receber, Double valorOperacao, int tipoOperacao) {
        Registro novoRegistro = new Registro();
        //COMUM EM TODAS OPERAÇÕES
        novoRegistro.setContaEnvio(enviar.getConta());
        novoRegistro.setValorOperacao(valorOperacao);
        novoRegistro.setSaldoPosOperacao(enviar.getSaldo());
        novoRegistro.setDataOperacao(LocalDateTime.now());
        //--------------------------------------------

        // Teste do Transactional
        // op_banco()
        // throw new erro()

//        registroRepository.mudarValorUltimoRegistrosDoDia(enviar.getConta().getId());
//        novoRegistro.setUltimoRegistroDoDia(true);

        if (tipoOperacao == 1) {
            novoRegistro.setOperacao("Deposito");
            if (novoRegistro.getSaldoPosOperacao() < 0) {
                double jurosDiario = ((novoRegistro.getSaldoPosOperacao() * (-1)) * enviar.getTaxaJuras());
//                novoRegistro.setValorDoJurosDiario(jurosDiario);
            }
            enviar.getRegistros().add(novoRegistro);

        } else if (tipoOperacao == 2) {
            novoRegistro.setOperacao("Saque");
            if (novoRegistro.getSaldoPosOperacao() < 0) {
                double jurosDiario = ((novoRegistro.getSaldoPosOperacao() * (-1)) * enviar.getTaxaJuras());
//                novoRegistro.setValorDoJurosDiario(jurosDiario);
            }
            enviar.getRegistros().add(novoRegistro);

        } else if (tipoOperacao == 3) {
            novoRegistro.setOperacao("Transferencia realizada");
            novoRegistro.setContaRecebimento(receber.getConta());
            enviar.getRegistros().add(novoRegistro);

        } else if (tipoOperacao == 4) {
            novoRegistro.setOperacao("Transferencia recebida");
            novoRegistro.setContaEnvio(enviar.getConta());
            novoRegistro.setContaRecebimento(receber.getConta());
            novoRegistro.setValorOperacao(valorOperacao);
            novoRegistro.setSaldoPosOperacao(receber.getSaldo());
            receber.getRegistros().add(novoRegistro);
            repository.save(receber);
        }

        repository.save(enviar);
    }

    public Movimentacao descontarJuros(Movimentacao movimentacao){
        if (movimentacao.getSaldo() >= 0) {
            double depositoMenosJuros = movimentacao.getSaldo() - movimentacao.getJurosDaConta();
            if (depositoMenosJuros > 0) {
                movimentacao.setSaldo(depositoMenosJuros);
                movimentacao.setJurosDaConta(0);
            }
        }
        return movimentacao;
    }

    public List<Registro> gerarExtrato(ExtratoDTO extrato) {
        LocalDate dataComeçoDoExtrato = LocalDate.now().minusDays(extrato.getDias());
        return registroRepository.extrato(extrato.getContaId(),dataComeçoDoExtrato);
    }
}

