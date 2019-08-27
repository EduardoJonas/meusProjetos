package info.dsandrade.pitagoras.modelo;

public class Operacao {
    private int fatorA;
    private int fatorB;
    private char operacao;

    public Operacao(int fatorA, int fatorB, char operacao) {
        this.fatorA = fatorA;
        this.fatorB = fatorB;
        this.operacao = operacao;
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
}
