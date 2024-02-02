package banco.exercicio05.registro;

import banco.exercicio05.conta.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataOperacao;

    private String operacao;

    private double valorOperacao;

    private double saldoPosOperacao;

    @OneToOne
    private Conta contaEnvio;

    @OneToOne
    private Conta contaRecebimento;

    public Registro() {
    }

    public Registro(Long id, LocalDateTime dataOperacao, String operacao, double valorOperacao, double saldoPosOperacao, Conta contaEnvio, Conta contaRecebimento) {
        this.id = id;
        this.dataOperacao = dataOperacao;
        this.operacao = operacao;
        this.valorOperacao = valorOperacao;
        this.saldoPosOperacao = saldoPosOperacao;
        this.contaEnvio = contaEnvio;
        this.contaRecebimento = contaRecebimento;
    }
}
