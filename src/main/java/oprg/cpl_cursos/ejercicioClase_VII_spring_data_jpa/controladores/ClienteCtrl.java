package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Cliente;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.ClienteSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteCtrl {

    private ClienteSrvc clienteSrvc;

    public ClienteCtrl(ClienteSrvc clienteSrvc) {
        this.clienteSrvc = clienteSrvc;
    }

    @GetMapping("/listado")
    public String listado(Model modelo) {
        List<Cliente> listaClientes = clienteSrvc.listarTodos();
        modelo.addAttribute("titulo", "Lista de Clientes");

        modelo.addAttribute("clientes", listaClientes);
        return "viistaLista";
    }


}
