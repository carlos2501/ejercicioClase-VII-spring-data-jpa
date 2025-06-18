package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Gama;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.GamaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaSrvc {
    private final GamaRepo gamaRepo;

    public GamaSrvc(GamaRepo gamaRepo) {
        this.gamaRepo = gamaRepo;
    }

    public List<Gama> listarTodos() {
        return gamaRepo.findAll();
    }
}
