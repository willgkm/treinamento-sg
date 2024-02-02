package sg.exercicio04.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService service;

    @GetMapping
    private List<File> getFile(){
        return service.filesList();
    }

    @GetMapping("/{id}")
    private File getFileById(@PathVariable("id") Long id){
        return service.consultFile(id);
    }

    @PostMapping("/register")
    private File postFile (File newFile) {
        return service.registerFile(newFile);
    }

    @PutMapping("/change/{id}")
    private File putFile(File modifieldFile){
        return this.service.changeFile(modifieldFile);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteFile (@PathVariable("id") Long id){
        service.deleteFile(id);
    }
}
