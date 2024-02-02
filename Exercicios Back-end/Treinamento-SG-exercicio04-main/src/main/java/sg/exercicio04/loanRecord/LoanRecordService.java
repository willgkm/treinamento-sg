package sg.exercicio04.loanRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.exercicio04.file.FileRepository;
import sg.exercicio04.file.FileService;
import sg.exercicio04.libraryUser.LibraryUser;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoanRecordService {

    @Autowired
    private LoanRecordRepository repository;

    @Autowired
    private FileService fileService ;

    public List<LoanRecord> LoanRecordsList(){
        return repository.findAll();
    }

    public LoanRecord findLoanRecord(Long id){
        return repository.findById(id).get();
    }

    public List<LoanRecord> notDeliveryByUserList(Long id){
        return repository.notDeliveryByUser(id);
    }

    public LoanRecord createLoanRecord(LoanRecord newLoanRecord){

        Long id = newLoanRecord.getUserLoan().getId();
        if (notDeliveryByUserList(id).size() > 2){
            throw new RuntimeException("The user reached the maximum number of loans");
        } else if(repository.loanDebts(id) > 0){
            throw new RuntimeException("The user must pay his debts first");
        } else if(repository.lateLoanRecords(id).size() > 0) {
            throw new RuntimeException("The user have to deliver his late loans first");
        } else {

        newLoanRecord.setDeliveryDate(CreateDeliveryDate());
        repository.save(newLoanRecord);

        fileService.changeTheAmountOfAvailableCopies(newLoanRecord.getFilesLoans(),true);
        return newLoanRecord;
        }
    }

    public LoanRecord Devolution (Long devolutionID){

        LoanRecord devolution = this.findLoanRecord(devolutionID);

        fineCalculation(devolution.getDeliveryDate());

        fileService.changeTheAmountOfAvailableCopies(devolution.getFilesLoans(),false);
        devolution.setDelivered(true);
        devolution.setFine(fineCalculation(devolution.getDeliveryDate()));
        repository.save(devolution);
        return devolution ;
    }

    public double fineCalculation(Date deliveryDate){
        //delivered date is the scheduled delivery date
        Calendar deliveredDate = Calendar.getInstance();
        deliveredDate.setTime(deliveryDate);

        //returned date is the date of the act of devolution
        Calendar returnedDate = Calendar.getInstance();
        double lateFine ;
        if(returnedDate.after(deliveredDate)) {
            lateFine = ((returnedDate.get(Calendar.DAY_OF_YEAR) - deliveredDate.get(Calendar.DAY_OF_YEAR)) * 2.5);
        } else {
            lateFine = 0;
        }
        return  lateFine;
    }

    public Date CreateDeliveryDate(){
        Calendar LoanDate = Calendar.getInstance();
        int weekLater = LoanDate.get(Calendar.DAY_OF_YEAR) + 7;
        LoanDate.set(Calendar.DAY_OF_YEAR,weekLater);
        return LoanDate.getTime();
    }

    public String payFine(Long loanRecordID){
        LoanRecord paidout = this.findLoanRecord(loanRecordID);
        if(paidout.getFine() > 0 ){
            paidout.setFine(0);
            repository.save(paidout);
        } else{
            throw new RuntimeException("there is no fine to pay");
        }
        return "fine paid successfully";
    }

    public void deleteLoanRecord(Long id){
        repository.deleteById(id);
    }

    public LoanRecord changeLoanRecord(LoanRecord modifield){
        modifield = repository.save(modifield);
        return modifield;
    }

}
