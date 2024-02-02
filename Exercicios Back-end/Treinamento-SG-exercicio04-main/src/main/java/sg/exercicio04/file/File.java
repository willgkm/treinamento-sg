package sg.exercicio04.file;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String fileType;

    private Long numberOfCopies;

    private Long availibleCopies = numberOfCopies;

    public File(Long id, String name, String fileType, Long numberOfCopies, Long availibleCopies) {
        this.id = id;
        this.name = name;
        this.fileType = fileType;
        this.numberOfCopies = numberOfCopies;
        this.availibleCopies = availibleCopies;
    }
    public File(){
    }
}
