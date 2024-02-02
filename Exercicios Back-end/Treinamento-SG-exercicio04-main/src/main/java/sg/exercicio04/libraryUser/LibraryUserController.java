package sg.exercicio04.libraryUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-user")
public class LibraryUserController {
    @Autowired
    private LibraryUserService service;

    @GetMapping
    private List<LibraryUser> getLibraryUser(){
        return service.LibraryUserList();
    }

    @GetMapping("/{id}")
    private LibraryUser getLibraryUserById(@PathVariable("id") Long id){
        return service.consultLibraryUser(id);
    }

    @PostMapping("/register")
    private LibraryUser postLibraryUser (LibraryUser newLibraryUser) {
        return service.createLibraryUser(newLibraryUser);
    }

    @PutMapping("/change/{id}")
    private LibraryUser putLibraryUser(LibraryUser modifieldLibraryUser){
        return this.service.changeLibrarUser(modifieldLibraryUser);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteLibraryUser (@PathVariable("id") Long id){
        service.deleteLibraryUser(id);
    }
}
