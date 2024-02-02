package sg.exercicio01.campeonato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.exercicio01.time.Time;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    public List<Campeonato> listarCampeonatos(){
        return repository.findAll();
    }

    public Campeonato salvarCampeonato(Campeonato novoCampeonato){
        novoCampeonato.setDataInicio(novoCampeonato.getDataInicio());
        return repository.save(novoCampeonato);
    }

    public void deletarCampeonato(Long id){
        repository.deleteById(id);
    }


}
