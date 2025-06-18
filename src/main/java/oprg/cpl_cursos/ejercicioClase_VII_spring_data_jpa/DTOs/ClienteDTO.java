package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DTOs;

public record ClienteDTO(
        Integer id,
        String nombreCliente,
        String telefono,
        String ciudad,
        String codigoPostal
) {}
