package sg.exercicio04.libraryUser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    public LibraryUser() {
    }

    public LibraryUser(Long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

}
