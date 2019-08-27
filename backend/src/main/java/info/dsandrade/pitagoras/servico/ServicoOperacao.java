package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;

public interface ServicoOperacao {

    Operacao geraOperacaoRandomica(int nivel);
    Operacao geraOperacaoSoma(int nivel);
    Operacao geraOperacaoSubtracao(int nivel);
    boolean checaTentativa(ResultadoTentativa tentativa);
}
