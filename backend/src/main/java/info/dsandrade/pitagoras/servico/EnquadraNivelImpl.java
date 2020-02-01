package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.Usuario;
import org.springframework.stereotype.Service;

@Service
public class EnquadraNivelImpl implements EnquadraNivel {
    @Override
    public int verificaNivelSoma(Usuario usuario) {
        return 1;
    }

    @Override
    public int verificaNivelSubtracao(Usuario usuario) {
        return 1;
    }

    @Override
    public int verificaNivelMultiplicacao(Usuario usuario) {
        return 1;
    }

    @Override
    public int verificaNivelDivisao(Usuario usuario) {
        return 1;
    }
}
