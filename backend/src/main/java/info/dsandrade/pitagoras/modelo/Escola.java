package info.dsandrade.pitagoras.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Escola {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private BigDecimal idebAI;
    private BigDecimal enemMediaGeral;
    private BigDecimal idebAF;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escola escola = (Escola) o;
        return Objects.equals(id, escola.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
