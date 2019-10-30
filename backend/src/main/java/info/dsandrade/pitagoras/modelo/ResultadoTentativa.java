package info.dsandrade.pitagoras.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class ResultadoTentativa {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Operacao operacao;
    private int valorTentativa;
    private boolean correta;

    public ResultadoTentativa(Usuario usuario, Operacao operacao, int tentativa) {
        this.usuario = usuario;
        this.operacao = operacao;
        this.valorTentativa = tentativa;
        this.correta = false;
    }

    public ResultadoTentativa() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoTentativa that = (ResultadoTentativa) o;
        return valorTentativa == that.valorTentativa &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(operacao, that.operacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, operacao, valorTentativa);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public int getValorTentativa() {
        return valorTentativa;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
