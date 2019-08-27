package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoOperacaoImpl implements ServicoOperacao {

    private GeraNumeroAleatorio geradorNumeroAleatorio;

    @Autowired
    public ServicoOperacaoImpl(GeraNumeroAleatorio geradorNumeroAleatorio) {
        this.geradorNumeroAleatorio = geradorNumeroAleatorio;
    }

    public ServicoOperacaoImpl() {
    }

    @Override
    public Operacao geraOperacaoRandomica(int nivel) {
        int fatorA = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        int fatorB = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        char op = '+';
        return new Operacao(fatorA, fatorB, op);
    }

    public Operacao geraOperacaoSoma(int nivel) {
        int fatorA = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        int fatorB = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        char op = '+';
        return new Operacao(fatorA, fatorB, op);
    }

    public Operacao geraOperacaoSubtracao(int nivel) {
        int fatorA = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        int fatorB = this.geradorNumeroAleatorio.gerarNumeroAleatorio(nivel);
        if (fatorB > fatorA) {
            fatorA += fatorB;
            fatorB = fatorA - fatorB;
            fatorA = fatorA - fatorB;
        }
        char op = '-';
        return new Operacao(fatorA, fatorB, op);
    }

    @Override
    public boolean checaTentativa(ResultadoTentativa tentativa) {
        Operacao operacao = tentativa.getOperacao();
        switch (operacao.getOperacao()) {
            case '+': return (operacao.getFatorA() + operacao.getFatorB()) == tentativa.getValorTentativa();
            case '-': return (operacao.getFatorA() - operacao.getFatorB()) == tentativa.getValorTentativa();
        }
        new Exception("Operação inválida");
        return  false;
    }
}
