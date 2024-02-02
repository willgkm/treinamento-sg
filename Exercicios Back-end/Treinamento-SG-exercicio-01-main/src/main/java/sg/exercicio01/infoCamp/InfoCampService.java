package sg.exercicio01.infoCamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoCampService {

    @Autowired
    private InfoCampRepository repository;

    public List<InfoCamp> listarTodos(){
        return repository.findAll();
    }

    public InfoCamp salvarInfoCamp(InfoCamp novaInfoCamp){
        return repository.save(novaInfoCamp);
    }

    public List<InfoCamp> listarCampOrdendado(Long id){
        return repository.ListaCampeonatoOrdenada(id);
    }

    public void deletarInfoCamp(long id) {
        repository.deleteById(id);
    }

}
