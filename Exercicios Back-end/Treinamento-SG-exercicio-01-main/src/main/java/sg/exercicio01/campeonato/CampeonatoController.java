package sg.exercicio01.campeonato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeonatos")

public class CampeonatoController {

    @Autowired
    private CampeonatoService service;


	@GetMapping
	public List<Campeonato> getAll() {
		return service.listarCampeonatos();
	}

	@PostMapping
	public Campeonato post(@RequestBody Campeonato novo) {
		return service.salvarCampeonato(novo);
	}

	@DeleteMapping("/{id}")
	public void deleteCampeonato(@PathVariable("id") Long id){
		service.deletarCampeonato(id);
	}

}
