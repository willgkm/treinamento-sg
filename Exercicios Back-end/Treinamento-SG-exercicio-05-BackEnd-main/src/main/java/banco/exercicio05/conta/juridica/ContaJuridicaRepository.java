package banco.exercicio05.conta.juridica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaJuridicaRepository extends JpaRepository<ContaJuridica, Long> {

    @Query(nativeQuery = true, value = "SELECT count (*) FROM conta_juridica cj " +
          "left join conta c on cj.cliente_juridico_id = c.id " +
          "where cliente_juridico_id = :cliente_juridico_id")
    int verificarExistenciaDeConta(@Param("cliente_juridico_id") Long id);

}
