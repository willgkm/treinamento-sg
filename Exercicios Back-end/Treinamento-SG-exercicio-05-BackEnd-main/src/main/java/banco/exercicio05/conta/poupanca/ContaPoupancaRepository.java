package banco.exercicio05.conta.poupanca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPoupancaRepository extends JpaRepository<ContaPoupanca,Long>{

    @Query(nativeQuery = true, value = "SELECT count (*) FROM conta_poupanca cf " +
          "left join conta c on cf.cliente_fisico_id = c.id " +
          "where cliente_fisico_id = :cliente_fisico_id")
    int verificarExistenciaDeConta(@Param("cliente_fisico_id") Long id);
}
