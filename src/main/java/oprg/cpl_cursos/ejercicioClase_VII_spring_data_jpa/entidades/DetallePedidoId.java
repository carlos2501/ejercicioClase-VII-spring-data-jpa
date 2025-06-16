package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class DetallePedidoId implements Serializable {
    private static final long serialVersionUID = -3295896381055332878L;
    @Column(name = "codigo_pedido", nullable = false)
    private Integer codigoPedido;

    @Column(name = "codigo_producto", nullable = false, length = 15)
    private String codigoProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetallePedidoId entity = (DetallePedidoId) o;
        return Objects.equals(this.codigoPedido, entity.codigoPedido) &&
                Objects.equals(this.codigoProducto, entity.codigoProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPedido, codigoProducto);
    }

}