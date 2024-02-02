package exercicio1.treinamentoSg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exercicio1.treinamentoSg.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE FUNCIONARIO SET STATUS_FUNCIONARIO = :STATUS_FUNCIONARIO WHERE ID = :ID", nativeQuery = true)
    void MudarStatusFuncicionario(@Param("STATUS_FUNCIONARIO") boolean status,@Param("ID") Long ID);
    
}
