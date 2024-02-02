package exercicio1.treinamentoSg.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Ponto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "horaPonto")
    private Date hora;

    @Column(name = "atrasado")
    private boolean atrasado;
    // true == está atrasado
    //false == não está atrasado

    @Column(name = "pontoConferido")
    private boolean pontoConferido;


    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Ponto() {
    }

    public Ponto(Long id, Date hora, boolean atrasado, Funcionario funcionario) {
        this.id = id;
        this.hora = hora;
        this.atrasado = atrasado;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean isAtrasado() {
        return atrasado;
    }

    public void setAtrasado(boolean atrasado) {
        this.atrasado = atrasado;
    }


    public boolean isPontoConferido() {
        return pontoConferido;
    }

    public void setPontoConferido(boolean pontoConferido) {
        this.pontoConferido = pontoConferido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
