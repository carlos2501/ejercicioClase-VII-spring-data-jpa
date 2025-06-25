package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empleado", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @ColumnDefault("NULL")
    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Column(name = "extension", length = 10)
    private String extension;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_oficina", nullable = false)
    private Oficina oficina;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe")
    private Empleado jefe;

    @ColumnDefault("NULL")
    @Column(name = "puesto", length = 50)
    private String puesto;

    @OneToMany(mappedBy = "repVentas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cliente> clientes = new LinkedHashSet<>();

    public String toListaExtendida() {
        return "Empleado: " + nombre + " " + apellido1 + " " + apellido2 +" - Puesto: " + puesto;
    }
}