package Exercicio03.Sg.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
