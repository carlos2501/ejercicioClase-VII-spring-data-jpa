package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductoGamaPK implements Serializable {
    @Column(name= "id_producto", nullable = false)
    private Integer idProducto;
    @Column(name= "id_gama", nullable = false)
    private Integer idGama;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoGamaPK that)) return false;

        return idProducto.equals(that.idProducto) && idGama.equals(that.idGama);
    }

    @Override
    public int hashCode() {
        int result = idProducto.hashCode();
        result = 31 * result + idGama.hashCode();
        return result;
    }
}
