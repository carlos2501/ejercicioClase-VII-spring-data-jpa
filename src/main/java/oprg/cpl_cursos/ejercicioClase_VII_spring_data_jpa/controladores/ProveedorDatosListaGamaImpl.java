package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.GamaSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaGamaImpl implements ProveedorDatosLista{
    private final GamaSrvc gamaSrvc;

    public ProveedorDatosListaGamaImpl(GamaSrvc gamaSrvc) {
        this.gamaSrvc = gamaSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Categorías de Producto";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Id", "Nombre", "Descripción");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        return gamaSrvc.listarTodos().stream()
                .map(ga -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", ga.getId());
                    fila.put("nombre", ga.getGama());
                    fila.put("descripcion",ga.getDescripcionTexto());
                    return fila;
                }).toList();
    }

    @Override
    public String getNombreEntidad() {
        return "gama";
    }
}
