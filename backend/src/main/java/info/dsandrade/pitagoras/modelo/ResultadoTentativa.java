package info.dsandrade.pitagoras.modelo;

import java.util.Objects;

public class ResultadoTentativa {

    Usuario usuario;
    Operacao operacao;
    int valorTentativa;

    public ResultadoTentativa(Usuario usuario, Operacao operacao, int tentativa) {
        this.usuario = usuario;
        this.operacao = operacao;
        this.valorTentativa = tentativa;
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
}
