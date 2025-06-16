package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "codigo_pedido", nullable = false)
    private Integer id;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "fecha_esperada", nullable = false)
    private LocalDate fechaEsperada;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @Column(name = "comentarios", length = Integer.MAX_VALUE)
    private String comentarios;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente codigoCliente;

    @OneToMany(mappedBy = "codigoPedido")
    private Set<oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DetallePedido> detallePedidos = new LinkedHashSet<>();

}