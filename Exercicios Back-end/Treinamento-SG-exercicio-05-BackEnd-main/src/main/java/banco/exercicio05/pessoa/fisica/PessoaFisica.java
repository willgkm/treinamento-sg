package banco.exercicio05.pessoa.fisica;

import banco.exercicio05.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }
}
