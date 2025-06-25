package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.mapeadores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DTOs.OficinaDTOFicha;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Oficina;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.LinkedHashSet;

@Mapper(componentModel = "spring")
public interface OficinaMap {
    @Mapping(target = "empleados", source = "empleados")
    OficinaDTOFicha oficinaToOficinaDTOFicha(Oficina oficina);

    @Mapping(target = "empleados", source = "empleados")
    Oficina oficinaDTOFichaToOficina(OficinaDTOFicha oficinaDTO);

    @AfterMapping
    default void afterToDTO(@MappingTarget OficinaDTOFicha dto, Oficina entity) {
        if (entity.getEmpleados() != null) {
            dto.empleados().addAll(new ArrayList<>(entity.getEmpleados()));
        }
    }

    @AfterMapping
    default void afterToEntity(@MappingTarget Oficina entity, OficinaDTOFicha dto) {
        if (dto.empleados() != null) {
            entity.getEmpleados().clear();
            entity.getEmpleados().addAll(new LinkedHashSet<>(dto.empleados()));
        }
    }
}
