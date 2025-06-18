package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Producto;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoSrvc {
    private final ProductoRepo productoRepo;

    public ProductoSrvc(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    public List<Producto> listarTodos() {
        return productoRepo.findAll();
    }
}
