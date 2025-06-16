package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gama_producto")
public class GamaProducto {
    @Id
    @SequenceGenerator(name = "gama_producto_id_gen", sequenceName = "empleado_codigo_empleado_seq", allocationSize = 1)
    @Column(name = "gama", nullable = false, length = 50)
    private String gama;

    @Column(name = "descripcion_texto", length = Integer.MAX_VALUE)
    private String descripcionTexto;

    @Column(name = "descripcion_html", length = Integer.MAX_VALUE)
    private String descripcionHtml;

    @Column(name = "imagen", length = 256)
    private String imagen;

    @OneToMany(mappedBy = "gama")
    private Set<oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.Producto> productos = new LinkedHashSet<>();

}