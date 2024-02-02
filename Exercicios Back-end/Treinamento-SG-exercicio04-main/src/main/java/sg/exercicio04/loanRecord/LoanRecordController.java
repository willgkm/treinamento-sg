package sg.exercicio04.loanRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanRecord")
public class LoanRecordController {

    @Autowired
    private LoanRecordService service;

    @GetMapping
    private List<LoanRecord> getLoanRecord(){
        return service.LoanRecordsList();
    }

    @GetMapping("/{id}")
    private LoanRecord getLoanRecordById(@PathVariable("id") Long id){
        return service.findLoanRecord(id);
    }

    @GetMapping("/user/{id}")
    private List<LoanRecord> NotDeliveryByUser(@PathVariable("id") Long id){
        return service.notDeliveryByUserList(id);
    }

    @PostMapping("/register")
    private LoanRecord postLoanRecord (LoanRecord newLoanRecord) {
        return service.createLoanRecord(newLoanRecord);
    }

    @PutMapping("/delivering/{id}")
    private LoanRecord  deliveringLoanRecord (@PathVariable("id") Long delivered){
        return this.service.Devolution(delivered);
    }

    @PutMapping ("/pay/{id}")
    private String payDebts (@PathVariable("id") Long id){
        return this.service.payFine(id);
    }

    @PutMapping("/change/{id}")
    private LoanRecord putLoanRecord(LoanRecord modifieldLoanRecord){
        return this.service.changeLoanRecord(modifieldLoanRecord);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteLoanRecord (@PathVariable("id") Long id){
        service.deleteLoanRecord(id);
    }
}
