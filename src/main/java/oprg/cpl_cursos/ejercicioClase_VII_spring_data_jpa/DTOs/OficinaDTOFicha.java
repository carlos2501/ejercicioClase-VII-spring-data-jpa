package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DTOs;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Empleado;

import java.util.List;

public record OficinaDTOFicha(
        String codigoOficina,
        String ciudad,
        String pais,
        String region,
        String codigoPostal,
        String telefono,
        String lineaDireccion1,
        String lineaDireccion2,
        List<Empleado> empleados
) {}
