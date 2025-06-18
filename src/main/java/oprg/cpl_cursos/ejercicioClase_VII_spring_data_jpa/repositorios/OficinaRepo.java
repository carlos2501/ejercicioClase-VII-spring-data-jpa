package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OficinaRepo extends JpaRepository<Oficina, String> {
}
