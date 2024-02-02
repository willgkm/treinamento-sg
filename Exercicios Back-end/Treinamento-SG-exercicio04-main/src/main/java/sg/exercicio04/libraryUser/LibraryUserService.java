package sg.exercicio04.libraryUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryUserService {

    @Autowired
    public LibraryUserRepository repository;

    public List<LibraryUser> LibraryUserList(){
        return repository.findAll();
    }

    public LibraryUser consultLibraryUser(Long id) {
        return repository.findById(id).get();
    }

    public LibraryUser createLibraryUser (LibraryUser newUser){
        repository.save(newUser);
        return newUser;
    }

    public void deleteLibraryUser(Long id){
        repository.deleteById(id);
    }

    public LibraryUser changeLibrarUser (LibraryUser modifield){
        modifield = repository.save(modifield);
        return  modifield;
    }

}
