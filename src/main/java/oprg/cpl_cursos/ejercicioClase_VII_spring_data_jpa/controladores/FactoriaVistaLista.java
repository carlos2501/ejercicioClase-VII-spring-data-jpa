package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FactoriaVistaLista {
    // Esta variable contiene el proveedor de datos -tipo ProveedorLista***Impl- para la vista de lista
    private final Map<String, ProveedorDatosLista> mapProveedorLista;

    public FactoriaVistaLista(List<ProveedorDatosLista> proveedorDatosParaLista) {
        // Creamos un mapa donde la clave es el nombre de la entidad y el valor es el proveedor.
        this.mapProveedorLista = proveedorDatosParaLista.stream()
                .collect(Collectors.toMap(ProveedorDatosLista::getNombreEntidad, Function.identity()));
    }

    public Optional<ProveedorDatosLista> getProveedorDatosLista(String nombreEntidad) {
        return Optional.ofNullable(mapProveedorLista.get(nombreEntidad));
    }
}
