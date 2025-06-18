package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Cliente;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.OficinaSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaOficinaImpl implements ProveedorDatosLista {
    private final OficinaSrvc ofiSrvc;

    public ProveedorDatosListaOficinaImpl(OficinaSrvc oficinaSrvc) {
        this.ofiSrvc = oficinaSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Oficinas";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Código", "Ciudad", "Teléfono");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Oficina> oficinas = ofiSrvc.listarTodos();
        List<Map<String, Object>> filas = oficinas.stream()
                .map(ofi -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", ofi.getCodigoOficina());
                    fila.put("ciudad", ofi.getCiudad());
                    fila.put("telefono", ofi.getTelefono());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "oficina";
    }
}
