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
}
