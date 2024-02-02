package Exercicio03.Sg.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;


    public Cliente(){

    }

    public Cliente(Long id, String nomeCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
    }



}
