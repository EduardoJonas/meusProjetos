package info.dsandrade.pitagoras.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Operacao {
    @Id
    @GeneratedValue
    private Long id;
    private int fatorA;
    private int fatorB;
    private char operacao;
    private int nivel;

    public Operacao(int fatorA, int fatorB, char operacao, int nivel) {
        this.fatorA = fatorA;
        this.fatorB = fatorB;
        this.operacao = operacao;
        this.nivel = nivel;
    }

    public Operacao() {

    }

    public int getFatorA() {
        return fatorA;
    }

    public int getFatorB() {
        return fatorB;
    }

    public char getOperacao() {
        return operacao;
    }

    public Long getId() {
        return id;
    }

    public int getNivel() {
        return nivel;
    }
}
