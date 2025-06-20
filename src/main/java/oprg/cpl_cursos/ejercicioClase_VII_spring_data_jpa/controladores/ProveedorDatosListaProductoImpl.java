package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.ProductoRepo;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.ProductoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaProductoImpl implements ProveedorDatosLista{
    private final ProductoSrvc productoSrvc;
    private final ProductoRepo productoRepo;

    public ProveedorDatosListaProductoImpl(ProductoSrvc productoSrvc,
                                           ProductoRepo productoRepo) {
        this.productoSrvc = productoSrvc;
        this.productoRepo = productoRepo;
    }

    @Override
    public String getTitulo() {
        return "Lista de Productos";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Código", "Nombre", "Proveedor", "P.V.P");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        return productoSrvc.listarTodos().stream()
                .map(prod -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", prod.getCodigoProducto());
                    fila.put("nombre", prod.getNombre());
                    fila.put("proveedor",prod.getProveedor());
                    fila.put("precioventa", prod.getPrecioVenta());
                    return fila;
                }).toList();
    }

    @Override
    public String getNombreEntidad() {
        return "producto";
    }

    @Override
    public Boolean hayDatosExtendidos() {
        return false;
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
