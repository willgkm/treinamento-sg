package sg.exercicio01.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Time salvarTime(Time novoTime){
        return repository.save(novoTime);
    }

    public List<Time> listarTimes(){
        return repository.findAll();
    }

    public void deletarTime(Long idTime){
        repository.deleteById(idTime);
    }
}
