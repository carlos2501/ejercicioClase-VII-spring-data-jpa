package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lineas_pedidos")
public class DetallePedido {
    @SequenceGenerator(name = "detalle_pedido_id_gen", sequenceName = "empleado_codigo_empleado_seq", allocationSize = 1)
    @EmbeddedId
    private DetallePedidoId id;

    @MapsId("codigoPedido")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido codigoPedido;

    @MapsId("codigoProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto codigoProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unidad", nullable = false, precision = 15, scale = 2)
    private BigDecimal precioUnidad;

    @Column(name = "numero_linea", nullable = false)
    private Short numeroLinea;

}