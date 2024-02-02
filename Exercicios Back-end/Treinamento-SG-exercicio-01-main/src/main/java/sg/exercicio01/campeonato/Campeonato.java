package sg.exercicio01.campeonato;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCamp;
    private Date dataInicio;
    private Date dataFim;

    public Campeonato() {
    }

    public Campeonato(Long id, String nomeCamp, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nomeCamp = nomeCamp;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
