package banco.exercicio05.conta.juridica;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import banco.exercicio05.conta.Conta;

import banco.exercicio05.pessoa.juridica.PessoaJuridica;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class ContaJuridica extends Conta {

    @OneToOne
    private PessoaJuridica clienteJuridico;

    public ContaJuridica() {
    }

    public ContaJuridica(PessoaJuridica clienteJuridico) {

        this.clienteJuridico = clienteJuridico;
    }

}

