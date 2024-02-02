package Exercicio03.Sg.orcamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository <Orcamento,Long> {

    @Query(nativeQuery = true,
    value = "SELECT  SUM(S.VALOR) " +
    "FROM ORCAMENTO O " +
    "LEFT JOIN ORCAMENTO_ITENS OI ON OI.ORCAMENTO_ID = O.ID " +
    "LEFT JOIN ITENS_ORCAMENTO IO ON IO.ID = OI.ITENS_ID " +
    "LEFT JOIN SERVICO S ON S.ID = IO.SERVICO_ID " +
    "WHERE O.ID =:O.ID")
    double somaValoresDosServicosNoOrcamento(@Param("O.ID") Long id);

    @Modifying
    @Query(nativeQuery = true, 
    value = "UPDATE ORCAMENTO " +
    "SET VALOR_TOTAL = :VALOR_TOTAL " +
    "WHERE ORCAMENTO.ID = :ORCAMENTO.ID") 
    void alterarValorTotalNaTabela(@Param("VALOR_TOTAL") double valorTotal,@Param("ORCAMENTO.ID") long id);
    
}



// SELECT  ORCAMENTO.ID, ORCAMENTO.FUNCIONARIO_ID, ORCAMENTO.VEICULO_ID, ORCAMENTO_ITENS.ITENS_ID , ITENS_ORCAMENTO.TEMPO_DE_SERVICO,
// ITENS_ORCAMENTO.SERVICO_ID, SERVICO.NOME, SERVICO.VALOR    
// FROM ORCAMENTO 
//  INNER JOIN ORCAMENTO_ITENS ON ORCAMENTO_ITENS.ORCAMENTO_ID = ORCAMENTO.ID
//  INNER JOIN ITENS_ORCAMENTO ON ITENS_ORCAMENTO.ID   =  ORCAMENTO_ITENS.ITENS_ID
//  INNER JOIN SERVICO ON SERVICO.ID   =  ITENS_ORCAMENTO.SERVICO_ID

// SELECT  *   
// FROM ORCAMENTO 
//  INNER JOIN ORCAMENTO_ITENS ON ORCAMENTO_ITENS.ORCAMENTO_ID = ORCAMENTO.ID
//  INNER JOIN ITENS_ORCAMENTO ON ITENS_ORCAMENTO.ID   =  ORCAMENTO_ITENS.ITENS_ID
//  INNER JOIN SERVICO ON SERVICO.ID   =  ITENS_ORCAMENTO.SERVICO_ID

// SELECT SUM(IO.TEMPO_DE_SERVICO), SUM(S.VALOR)
// FROM ORCAMENTO O
// LEFT JOIN ORCAMENTO_ITENS OI ON OI.ORCAMENTO_ID = O.ID 
// LEFT JOIN ITENS_ORCAMENTO IO ON IO.ID = OI.ITENS_ID
// LEFT JOIN SERVICO S ON S.ID = IO.SERVICO_ID 
// WHERE O.ID =3