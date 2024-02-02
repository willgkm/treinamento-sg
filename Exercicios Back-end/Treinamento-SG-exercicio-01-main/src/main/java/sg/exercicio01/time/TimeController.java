package sg.exercicio01.time;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @PostMapping
	public Time post(@RequestBody Time novo) {
		return service.salvarTime(novo);
	}   
    
    @GetMapping
	public List<Time> getAll() {
		return service.listarTimes();
	}

    @DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable("id") Long id) {
		service.deletarTime(id);
	}

}
