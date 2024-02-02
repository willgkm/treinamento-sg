package banco.exercicio05.conta;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long agencia = 10L;

    public Conta() {
    }

    public Conta(Long id) {
        this.id = id;

    }


}