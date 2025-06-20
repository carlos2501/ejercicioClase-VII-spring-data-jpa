package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.EmpleadoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaEmpleadoImpl implements ProveedorDatosLista{
    private final EmpleadoSrvc empleadoSrvc;

    public ProveedorDatosListaEmpleadoImpl(EmpleadoSrvc empleadoSrvc) {
        this.empleadoSrvc = empleadoSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Empleado";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Id", "Nombre", "Apellidos", "Puesto");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        return empleadoSrvc.listarTodos().stream()
                .map(emp -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", emp.getId());
                    fila.put("nombre", emp.getNombre());
                    fila.put("apellidos",emp.getApellido1() + " " + emp.getApellido2());
                    fila.put("puesto", emp.getPuesto());
                    return fila;
                }).toList();
    }

    @Override
    public String getNombreEntidad() {
        return "empleado";
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
