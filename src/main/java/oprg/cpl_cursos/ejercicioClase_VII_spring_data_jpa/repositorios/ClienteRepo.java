package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
