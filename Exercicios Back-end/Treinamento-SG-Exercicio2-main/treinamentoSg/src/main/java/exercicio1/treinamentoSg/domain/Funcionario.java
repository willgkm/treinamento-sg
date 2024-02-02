package exercicio1.treinamentoSg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeFuncionario")
    private String nome;

    @Column(name = "statusFuncionario")
    private boolean bloqueio;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }



}
