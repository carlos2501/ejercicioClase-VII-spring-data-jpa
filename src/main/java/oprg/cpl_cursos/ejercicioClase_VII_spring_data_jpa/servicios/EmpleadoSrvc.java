package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Empleado;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoSrvc {
    private final EmpleadoRepo empleadoRepo;

    public EmpleadoSrvc(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> listarTodos() {
        return empleadoRepo.findAll();
    }

    //ejemplo de LazyInitializationException
    public String getOficinaDeEmpleado(Integer empleadoId) {
        Empleado empleado = empleadoRepo.findById(empleadoId)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        // Esto provocará LazyInitializationException porque intentamos acceder
        // a la oficina fuera de la transacción
        return "El empleado " + empleado.getNombre() +
                " trabaja en la oficina: " + empleado.getOficina().getCodigoOficina();
    }

}
