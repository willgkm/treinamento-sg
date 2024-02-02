package banco.exercicio05.conta.fisica;

import banco.exercicio05.conta.Conta;
import banco.exercicio05.pessoa.fisica.PessoaFisica;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class ContaFisica extends Conta {


    @OneToOne
    private PessoaFisica clienteFisico;


    public ContaFisica() {
    }

    public ContaFisica(Long id, PessoaFisica clienteFisico) {
        super(id);
        this.clienteFisico = clienteFisico;
    }
}
