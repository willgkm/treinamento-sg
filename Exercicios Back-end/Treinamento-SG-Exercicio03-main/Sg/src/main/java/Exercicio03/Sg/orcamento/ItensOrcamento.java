package Exercicio03.Sg.orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Exercicio03.Sg.servico.Servico;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItensOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observação;

    private int tempoDeServico;

    @ManyToOne
    private Servico servico;

    public ItensOrcamento() {
    }

    public ItensOrcamento(Long id, String observação, int tempoDeServico, Servico servico) {
        this.id = id;
        this.observação = observação;
        this.tempoDeServico = tempoDeServico;
        this.servico = servico;
    }

}
