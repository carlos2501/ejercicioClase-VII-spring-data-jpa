package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import lombok.RequiredArgsConstructor;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Cliente;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.ClienteSrvc;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProveedorDatosListaClienteImpl implements ProveedorDatosLista{
    private final ClienteSrvc clienteSrvc;

    public ProveedorDatosListaClienteImpl(ClienteSrvc clienteSrvc) {
        this.clienteSrvc = clienteSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Clientes";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Id", "Nombre", "Teléfono", "Ciudad", "C.P.");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Cliente> clientes = clienteSrvc.listarTodos();
        List<Map<String, Object>> filas = clientes.stream()
                .map(cli -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", cli.getId());
                    fila.put("nombreCliente", cli.getNombreCliente());
                    fila.put("telefono", cli.getTelefono());
                    fila.put("ciudad", cli.getCiudad());
                    fila.put("codigoPostal", cli.getCodigoPostal());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "cliente";
    }
}
