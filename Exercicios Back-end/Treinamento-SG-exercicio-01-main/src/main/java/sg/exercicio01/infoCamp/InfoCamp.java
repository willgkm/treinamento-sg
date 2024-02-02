package sg.exercicio01.infoCamp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import sg.exercicio01.campeonato.Campeonato;
import sg.exercicio01.time.Time;

@Entity
@Getter
@Setter
public class InfoCamp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Campeonato campeonato;
    
    @ManyToOne
    private Time time;

    private Long pontos = gerarAleatorios();


    public InfoCamp(){
    }

    public InfoCamp(Long id, Campeonato campeonato, Time time, Long pontos) {
        this.id = id;
        this.campeonato = campeonato;
        this.time = time;
        this.pontos = pontos;
    }

    public Long gerarAleatorios(){
        // Random aleatorio = new Random();
        Long x = (long) (Math.random() * 99L);
        return x;
    }

}
