package sg.exercicio04.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository repository;

    public List<File> filesList(){
        return repository.findAll();
    }

    public File consultFile(Long id){
        return repository.findById(id).get();
    }

    public File registerFile(File newFile){
        newFile.setAvailibleCopies(newFile.getNumberOfCopies());
        repository.save(newFile);
        return newFile;
    }

    public void deleteFile (Long id) {
        repository.deleteById(id);

    }

    public File changeFile(File modifield){
        modifield = repository.save(modifield);
        return modifield;
    }

    public void changeTheAmountOfAvailableCopies(File copies, Boolean loan){
        if (loan) {
            copies.setAvailibleCopies(copies.getAvailibleCopies() - 1L);
        } else {
            copies.setAvailibleCopies(copies.getAvailibleCopies() + 1L);
        }
          repository.save(copies);
    }

 }
