package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.Usuario;

public interface EnquadraNivel {
    int verificaNivelSoma(Usuario usuario);
    int verificaNivelSubtracao(Usuario usuario);
    int verificaNivelMultiplicacao(Usuario usuario);
    int verificaNivelDivisao(Usuario usuario);
}
