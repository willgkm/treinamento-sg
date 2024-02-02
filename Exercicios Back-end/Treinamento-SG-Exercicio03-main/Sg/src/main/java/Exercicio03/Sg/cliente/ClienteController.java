package Exercicio03.Sg.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteService serviceCliente;
    
    @GetMapping
    private List<Cliente> getClientes(){
        return this.serviceCliente.listarClientes();
    }

    @GetMapping("/{id}")
    private Cliente getClientePeloId(@PathVariable("id") long id){
        return this.serviceCliente.pesquisarCliente(id);
    }

    @PostMapping("/cadastrar")
    private Cliente postCliente(@RequestBody Cliente novoCliente){
        return this.serviceCliente.cadastrarCliente(novoCliente);
    }   

    @DeleteMapping("/excluir/{id}")
    private String deleteCliente(@PathVariable("id") Long id){
        return this.serviceCliente.deletarCliente(id);
    }


}
