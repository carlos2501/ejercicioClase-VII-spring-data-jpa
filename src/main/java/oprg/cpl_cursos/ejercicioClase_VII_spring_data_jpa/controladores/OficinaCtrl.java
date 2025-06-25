package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;


import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DTOs.OficinaDTOFicha;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.OficinaSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oficina")
public class OficinaCtrl {

    private final OficinaSrvc ofiSrvc;

    public OficinaCtrl(OficinaSrvc ofiSrvc) {
        this.ofiSrvc = ofiSrvc;
    }

    @GetMapping("/{ofi}")
    @Transactional(readOnly = true)
    public String fichaOficina(@PathVariable String ofi, Model modelo) {
        // 1 - Obtener los datos de la oficina
        Oficina oficina = ofiSrvc.cargarOficina(ofi).orElseThrow();

        //1b - Asignamos los datos al modelo
        modelo.addAttribute("oficina", oficina);
        // 2 - Enviar los datos a la plantilla
        return "fichaOficina";
    }

    @PostMapping("/guardar")
    public String guardarOficina(@ModelAttribute OficinaDTOFicha ofi) {
        // 1 - Verificar los datos recibidos (no se hace en este ejemplo)
        Oficina oficina = ofiSrvc.aEntidad(ofi);
        // 2- Guardar en la BBDD
        ofiSrvc.grabarOficina(oficina);
        return "redirect:/lista/oficina";
    }
}
