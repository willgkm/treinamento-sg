package sg.exercicio04.loanRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord,Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM loan_record where user_id  = :user_id and delivered = false")
    List<LoanRecord> notDeliveryByUser(@Param("user_id") Long id);

    @Query(nativeQuery = true,
    value = "SELECT sum(fine) FROM public.loan_record where user_id = :user_id")
    Double loanDebts (@Param("user_id") Long id);

    @Query(nativeQuery = true,value = "SELECT * FROM public.loan_record where delivery_date < current_timestamp and delivered = false and user_id = :user_id")
    List<LoanRecord> lateLoanRecords(@Param("user_id") Long id);

}
