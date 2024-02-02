package Exercicio03.Sg.funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    
    private String nomeFuncionario;

    public Funcionario(){
        
    }

    public Funcionario(Long id, String nomeFuncionario) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
    }

    
}
