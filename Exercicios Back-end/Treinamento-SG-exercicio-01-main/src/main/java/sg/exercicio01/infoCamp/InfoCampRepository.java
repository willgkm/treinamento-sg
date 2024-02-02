package sg.exercicio01.infoCamp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoCampRepository extends JpaRepository<InfoCamp,Long> {

    @Query(value = "SELECT * FROM INFO_CAMP WHERE CAMPEONATO_ID = :CAMPEONATO_ID ORDER BY PONTOS DESC", nativeQuery = true )
    List<InfoCamp> ListaCampeonatoOrdenada(@Param("CAMPEONATO_ID") Long CAMPEONATO_ID);

}
