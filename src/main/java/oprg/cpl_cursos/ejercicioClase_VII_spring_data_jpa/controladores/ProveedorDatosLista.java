package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import java.util.List;
import java.util.Map;

/**
 * Interfaz para proveedores de datos para la vista de lista genérica.
 * Cada implementación será responsable de una entidad específica.
 */
public interface ProveedorDatosLista {
    /**
     * Devuelve el título de la página.
     */
    String getTitulo();
    /**
     * Devuelve las cabeceras de la tabla.
     */
    List<String> getCabeceras();
    /**
     * Devuelve los datos de las filas. Cada fila es una lista de objetos.
     */
    List<Map<String, Object>> getFilas();
    /**
     * Devuelve el nombre de la entidad que gestiona, para el registro.
     */
    String getNombreEntidad();
    /**
     * Devuelve si la entidad utiliza o no datos extendidos
     */
    Boolean hayDatosExtendidos();
    /**
     * Devuelve las cabeceras de la tabla secundaria que aparece debajo de cada fila si hay hatos extendidos
     */
    Map<String, String> getCabecerasExtendidas();
}
