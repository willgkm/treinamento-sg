package sg.exercicio01.campeonato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato,Long> {
    
}
