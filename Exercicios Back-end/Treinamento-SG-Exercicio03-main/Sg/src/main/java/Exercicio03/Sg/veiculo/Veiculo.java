package Exercicio03.Sg.veiculo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Exercicio03.Sg.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String placa;

    @ManyToOne
    private Cliente cliente;

    public Veiculo(){

    }

    public Veiculo(Long id, String modelo, String placa, Cliente cliente) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.cliente = cliente;
    }
    



    
}
