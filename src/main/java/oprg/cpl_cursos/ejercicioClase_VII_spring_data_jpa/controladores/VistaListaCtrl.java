package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/lista")
public class VistaListaCtrl{
    private final FactoriaVistaLista factoriaVistaLista;

    public VistaListaCtrl(FactoriaVistaLista factoriaVistaLista) {
        this.factoriaVistaLista = factoriaVistaLista;
    }

    @GetMapping("/{nombreEntidad}")
    public String listarDatos(@PathVariable String nombreEntidad, Model modelo){
        // Obtenemos los datos a visualizar desde el proveedor de esos datos suministrado por la factoría
        ProveedorDatosLista proveedor = factoriaVistaLista.getProveedorDatosLista(nombreEntidad)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidad no encontrada: " + nombreEntidad));
        // Asignamos los datos al modelo
        modelo.addAttribute("titulo", proveedor.getTitulo());
        modelo.addAttribute("cabeceras", proveedor.getCabeceras());
        modelo.addAttribute("filas", proveedor.getFilas());
        modelo.addAttribute("cabecerasExtendidas", proveedor.getCabecerasExtendidas());
        // llamamos a la plantilla de thymeleaf
        return "vistaLista";
    }

}
