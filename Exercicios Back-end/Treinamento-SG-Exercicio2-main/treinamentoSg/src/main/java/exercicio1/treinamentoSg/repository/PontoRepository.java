package exercicio1.treinamentoSg.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exercicio1.treinamentoSg.domain.Funcionario;
import exercicio1.treinamentoSg.domain.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto,Long> {
    
    List<Ponto> findByFuncionario(Funcionario funcionario);

    @Query(value = "SELECT * FROM PONTO WHERE FUNCIONARIO_ID = :FUNCIONARIO_ID", nativeQuery = true )
    List<Ponto> listaPontoPorIdFuncionario(@Param("FUNCIONARIO_ID") Long  FUNCIONARIO_ID);

    @Query(value = "SELECT * FROM PONTO WHERE FUNCIONARIO_ID = :FUNCIONARIO_ID AND HORA_PONTO > :HORA_PONTO ", nativeQuery = true )
    List<Ponto> listaPontosDoFuncionarioDIA(@Param("FUNCIONARIO_ID") Long  FUNCIONARIO_ID, @Param ("HORA_PONTO") Date HORA_PONTO);

    @Modifying
    @TransactionScoped
    @Query(value = "SELECT * FROM PONTO " + 
    "WHERE ATRASADO = TRUE " +
    "AND HORA_PONTO > :HORA_PONTO " +
    "AND FUNCIONARIO_ID = :FUNCIONARIO_ID "
    , nativeQuery = true )
    List<Ponto> listaDeAtrasosDoFuncionarioNaSemana(@Param("HORA_PONTO") Date HORA_PONTO, Long FUNCIONARIO_ID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PONTO " +
    "SET PONTO_CONFERIDO = TRUE " + 
    "WHERE FUNCIONARIO_ID = :FUNCIONARIO_ID " + 
    "AND PONTO_CONFERIDO = FALSE", nativeQuery = true)
    void conferirPontosAtrasados(@Param("FUNCIONARIO_ID") Long  FUNCIONARIO_ID);


}
