package banco.exercicio05.conta.fisica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaFisicaRepository extends JpaRepository<ContaFisica, Long> {

    @Query(nativeQuery = true, value = "SELECT count (*) FROM conta_fisica cf " +
          "left join conta c on cf.cliente_fisico_id = c.id " +
          "where cliente_fisico_id = :cliente_fisico_id")
    int verificarExistenciaDeConta(@Param("cliente_fisico_id") Long id);

}
