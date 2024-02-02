package Exercicio03.Sg.servico;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private double valor;

    public Servico() {
    }

    public Servico(Long id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }



}
