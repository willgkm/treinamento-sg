package exercicio1.treinamentoSg.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercicio1.treinamentoSg.domain.Ponto;
import exercicio1.treinamentoSg.repository.PontoRepository;


@Service
public class PontoService {
    
    @Autowired
    private PontoRepository repository;

    @Autowired
    private FuncionarioService funcionarioService;


    public List<Ponto> listarPonto(){
        return repository.findAll();
    }

    public Ponto pegarUmPonto(Long id){
        return repository.findById(id).get();
    }

    public List<Ponto> pegarPontosDeUmFuncionario(Long id){
        return repository.listaPontoPorIdFuncionario(id);
    }

    public List<Ponto> ListaPontosDoFuncionarioDia(Long id){
        Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0); 
        Date dia = c.getTime();
        return repository.listaPontosDoFuncionarioDIA(id, dia);
    }

    public List<Ponto> AtrasosDoFuncionarioNaSemana(Long id){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0); 
        Date dia = c.getTime();
        return repository.listaDeAtrasosDoFuncionarioNaSemana(dia, id);
    }

    public String criarPonto(Ponto novoPonto){

        if (novoPonto.getFuncionario().isBloqueio() == false ){
            //verificação se esta atrasado.
            novoPonto.setAtrasado(verificarHorario(novoPonto));

            novoPonto.setPontoConferido(false);

            //salva o registro
            repository.save(novoPonto);

            //verifica e faz o bloqueio
            verificaParaBloqueio(novoPonto);

            //retora uma mensaguem personalizada para cada ponto especifico do dia
            return mensagemDoPonto(novoPonto);

        }else{
            return ("usuario bloqueado, visite o RH para efetuar o desbloqueio");
        }
    }
    
    public Boolean verificarHorario(Ponto novoPonto){
        
        //condição de entrada
        //condição para verificar se o novoPonto é ou não uma primeira entrada no serviço
        boolean condicaoDeEntrada = (ListaPontosDoFuncionarioDia(novoPonto.getFuncionario().getId()).size() == 0);

        //condição de horario
        //verifica se o horario do ponto é depois do limite de entrada, ou seja, verifica se o usuario esta ou não atrasado
        
        Calendar horaAtual = Calendar.getInstance();
        Calendar limiteEntrada = Calendar.getInstance();
		limiteEntrada.set(Calendar.HOUR_OF_DAY, 9);
		limiteEntrada.set(Calendar.MINUTE, 0);
		limiteEntrada.set(Calendar.SECOND, 0);
        
        //condição de horario = se a horaAtual for DEPOIS de Limite entrada, retorna true 
        boolean condicaoDeHorario = horaAtual.after(limiteEntrada);

        if (condicaoDeEntrada == true && condicaoDeHorario == true){
            return true;
        } else {
            return false;
        }

    }

    public int contarNumeroDePontoNoDia(Long id){
        return ListaPontosDoFuncionarioDia(id).size();
    }

    public String mensagemDoPonto (Ponto ponto){

        int contadorDePonto = contarNumeroDePontoNoDia(ponto.getFuncionario().getId());

        if(contadorDePonto == 1 ){
                return ("Registro de começo de expediente"
                +"\nData :" + ponto.getHora());

        } else if (contadorDePonto == 2 ) {
                return ("Registro de saida de almoço : "
                +"\nData :" + ponto.getHora());

        } else if (contadorDePonto == 3) {
            return ("Registro de volta do almoço: "
                +"\nData :" + ponto.getHora());

        } else if (contadorDePonto == 4 ) {
            return ("Registro de fim de expediente : "
            +"\nData :" + ponto.getHora());

        } else {
            return ("ponto extra registrado as : "
            +"\nData :" + ponto.getHora());
        }
    }

    public int verificaParaBloqueio(Ponto ponto){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0); 
        Date dia = c.getTime();
        Long id = ponto.getFuncionario().getId();
        int contadorParaBloqueio = repository.listaDeAtrasosDoFuncionarioNaSemana(dia,id).size();
        if (contadorParaBloqueio > 3)
            funcionarioService.bloquearFuncionario(id);
        return  contadorParaBloqueio;
    }

}
