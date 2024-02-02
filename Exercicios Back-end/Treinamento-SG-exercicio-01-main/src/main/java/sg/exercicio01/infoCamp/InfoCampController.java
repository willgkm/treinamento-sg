package sg.exercicio01.infoCamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info-camp")
public class InfoCampController {

    @Autowired
    private InfoCampService service;

    @PostMapping
    public InfoCamp post(@RequestBody InfoCamp novoCampeonato) {
		return service.salvarInfoCamp(novoCampeonato);
    }

    @GetMapping
    public List<InfoCamp> getAll() {
        return service.listarTodos();
	}

    @GetMapping("/detalhes/{id}")
    public List<InfoCamp> getCampeonatoOrdenado(@PathVariable("id") Long CAMP_ID){
        return service.listarCampOrdendado(CAMP_ID);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id ){
        service.deletarInfoCamp(id);
    }
}
