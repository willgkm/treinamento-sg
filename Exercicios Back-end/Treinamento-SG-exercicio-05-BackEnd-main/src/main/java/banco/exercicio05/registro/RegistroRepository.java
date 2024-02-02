package banco.exercicio05.registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM registro\n" +
          "where conta_envio_id = :conta_envio_id \n" +
          "order by conta_envio_id desc limit 1")
    Registro ultimoRegistro(@Param("conta_envio_id") Long id);


    @Query(nativeQuery = true, value = "select  * from registro " +
          "where data_operacao > current_date " +
          "and conta_envio_id = :conta_envio_id")
    List<Registro> listaDeRegistrosDoDia(@Param("conta_envio_id") Long conta_envio_id);

    @Query(nativeQuery = true, value = "SELECT * FROM registro \n" +
          "where conta_envio_id = :conta_envio_id \n" +
          "and data_operacao > :data_operacao ")
    List<Registro> extrato(@Param("conta_envio_id") Long conta_envio_id, @Param("data_operacao") LocalDate data_operacao);

}