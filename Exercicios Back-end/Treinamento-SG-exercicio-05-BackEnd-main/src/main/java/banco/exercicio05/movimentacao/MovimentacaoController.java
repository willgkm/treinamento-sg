package banco.exercicio05.movimentacao;

import banco.exercicio05.registro.Registro;
import banco.exercicio05.registro.dto.ExtratoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    private List<Movimentacao> getAll() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    private Movimentacao getAll(Long id) {
        return service.buscarMovimentacao(id);
    }

    @GetMapping("/saldo-da-conta/{id}")
    private Movimentacao getByConta(@PathVariable("id") Long id) {
        return service.buscarMovimentacaoPorConta(id);
    }

    @PostMapping("/extrato")
    private List<Registro> mostrarExtrato(@RequestBody ExtratoDTO extratoDTO){
        return service.gerarExtrato(extratoDTO);
    }

    @PutMapping("/{id}/depositar/{valor}")
    private Movimentacao deposistar(@PathVariable("id") Long id, @PathVariable("valor") double valor) {
        return service.realizarDeposito(id, valor);
    }

    @PutMapping("/{id}/saque/{valor}")
    private Movimentacao sacar(@PathVariable("id") Long id, @PathVariable("valor") double valor) {
        return service.realizarSaque(id, valor);
    }

    @PutMapping("/{idEnviar}/transferencias/{idReceber}/valor/{valor}")
    private Movimentacao transferencia(@PathVariable("idEnviar") Long idEnviar, @PathVariable("idReceber") Long idReceber, @PathVariable("valor") double valor) {
        return service.realizarTransferencia(idEnviar, idReceber, valor);
    }

}
