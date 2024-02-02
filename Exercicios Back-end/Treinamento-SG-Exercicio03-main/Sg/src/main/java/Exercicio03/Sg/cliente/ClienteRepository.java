package Exercicio03.Sg.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
