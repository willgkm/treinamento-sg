package banco.exercicio05.movimentacao;

import banco.exercicio05.movimentacao.projection.MovimentacaoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM movimentacao " +
          "where conta_id = :conta_id ")
    Movimentacao buscarMovimentacaoPorConta(@Param("conta_id") Long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM movimentacao " +
//            "where conta_id = :conta_id ")
//    List<MovimentacaoProjection> testeProjection(@Param("id") Long id );

}