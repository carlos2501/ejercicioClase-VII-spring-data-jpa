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
public class PagoId implements Serializable {
    private static final long serialVersionUID = 6905635386182904423L;
    @Column(name = "codigo_cliente", nullable = false)
    private Integer codigoCliente;

    @Column(name = "id_transaccion", nullable = false, length = 50)
    private String idTransaccion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PagoId entity = (PagoId) o;
        return Objects.equals(this.idTransaccion, entity.idTransaccion) &&
                Objects.equals(this.codigoCliente, entity.codigoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaccion, codigoCliente);
    }

}