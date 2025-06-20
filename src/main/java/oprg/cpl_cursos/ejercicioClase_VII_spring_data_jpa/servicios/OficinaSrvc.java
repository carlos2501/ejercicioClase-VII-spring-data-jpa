package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Empleado;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaSrvc {
    private final OficinaRepo oficinaRepo;

    public OficinaSrvc(OficinaRepo oficinaRepo) {
        this.oficinaRepo = oficinaRepo;
    }

    public List<Oficina> listarTodos() {
        return oficinaRepo.findAll();
    }

    public Optional<Oficina> cargarOficina(String oficinaId) {
        return oficinaRepo.findById(oficinaId);
    }

    public void grabarOficina(Oficina oficina) {
        oficinaRepo.save(oficina);
    }
}
