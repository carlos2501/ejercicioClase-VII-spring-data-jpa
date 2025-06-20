package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.OficinaSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oficina")
public class OficinaCtrl {

    private final OficinaSrvc ofiSrvc;

    public OficinaCtrl(OficinaSrvc ofiSrvc) {
        this.ofiSrvc = ofiSrvc;
    }

    @GetMapping("/{ofi}")
    public String fichaOficina(@PathVariable String ofi, @ModelAttribute Oficina oficina) {
        // 1 - Obtener los datos de la oficina
        oficina = ofiSrvc.cargarOficina(ofi).orElseThrow();
        // 2 - Enviar los datos a la plantilla
        return "fichaOficina";
    }
}
