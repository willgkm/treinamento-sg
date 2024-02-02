package Exercicio03.Sg.orcamento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import Exercicio03.Sg.funcionario.Funcionario;
import Exercicio03.Sg.veiculo.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Veiculo veiculo;
    
    @OneToOne
    private Funcionario funcionario;

    private double valorTotal;
    
    private int diasTotaisDeServico;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItensOrcamento> itens;

    public Orcamento() {
    }

    public Orcamento(Long id, Veiculo veiculo, Funcionario funcionario, double valorTotal, int diasTotaisDeServico,
            List<ItensOrcamento> itens) {
        this.id = id;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
        this.diasTotaisDeServico = diasTotaisDeServico;
        this.itens = itens;
    }
    


    
    
}
