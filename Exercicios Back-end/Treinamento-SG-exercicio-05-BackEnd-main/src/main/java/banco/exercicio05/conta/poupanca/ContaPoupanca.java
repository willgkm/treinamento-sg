package banco.exercicio05.conta.poupanca;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import banco.exercicio05.conta.Conta;

import banco.exercicio05.pessoa.fisica.PessoaFisica;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class ContaPoupanca extends Conta{

    @OneToOne
    private PessoaFisica clienteFisico;

    public ContaPoupanca() {
    }

    public ContaPoupanca(PessoaFisica clienteFisico) {
        this.clienteFisico = clienteFisico;
    }

    
}
