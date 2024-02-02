package banco.exercicio05.movimentacao;

import banco.exercicio05.conta.Conta;
import banco.exercicio05.registro.Registro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double saldo = 0;

    private double limiteCredito;

    private double taxaJuras = 0.02d;

    private double jurosDaConta = 0;

    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Movimentacao_id")
    private List<Registro> registros;

    public Movimentacao() {

    }

    public Movimentacao(Long id, double saldo, double limiteCredito) {
        this.id = id;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }

}
