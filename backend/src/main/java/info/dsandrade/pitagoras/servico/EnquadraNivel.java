package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.Usuario;

public interface EnquadraNivel {
    final Integer[] TROCA_NIVEL = {10, 20, 30, 40, 50};

    int verificaNivelSoma(Usuario usuario);
    int verificaNivelSubtracao(Usuario usuario);
    int verificaNivelMultiplicacao(Usuario usuario);
    int verificaNivelDivisao(Usuario usuario);
    int proximoNivel(Usuario usuario, char operacao);
}
