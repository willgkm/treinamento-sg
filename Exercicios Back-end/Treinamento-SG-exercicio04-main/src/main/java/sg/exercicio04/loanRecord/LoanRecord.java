package sg.exercicio04.loanRecord;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import sg.exercicio04.file.File;
import sg.exercicio04.libraryUser.LibraryUser;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class LoanRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp()
    private Date loanDate;

    private Date deliveryDate;

    private Boolean Delivered = false;

    private double fine;

    @OneToOne
    @JoinColumn(name ="file_ID",nullable = false)
    private File filesLoans;

    @OneToOne
    @JoinColumn(name = "user_ID",nullable = false)
    private LibraryUser userLoan;

    public LoanRecord() {
    }

    public LoanRecord(File filesLoans, LibraryUser userLoan) {
        this.filesLoans = filesLoans;
        this.userLoan = userLoan;
    }



}
