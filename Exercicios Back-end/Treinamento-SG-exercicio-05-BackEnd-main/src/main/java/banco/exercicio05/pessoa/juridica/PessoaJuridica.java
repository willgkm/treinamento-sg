package banco.exercicio05.pessoa.juridica;

import banco.exercicio05.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

}
