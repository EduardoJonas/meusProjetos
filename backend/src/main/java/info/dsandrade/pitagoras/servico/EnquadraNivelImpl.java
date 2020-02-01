package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.ResultadoTentativaRepository;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnquadraNivelImpl implements EnquadraNivel {

    @Autowired
    private ResultadoTentativaRepository repositoryTentativa;
    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Override
    public int verificaNivelSoma(Usuario usuario) {
        return proximoNivel(usuario, '+');
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

    @Override
    public int proximoNivel(Usuario usuario, char operacao) {
        int nivelDaOperacao = usuario.getNivelPorOperacao(operacao);
        List<ResultadoTentativa> usuarioTentativasCorretas = repositoryTentativa.findByUsuarioAndCorretaIsTrue(usuario);
        if (usuarioTentativasCorretas.size() > TROCA_NIVEL[usuario.getNivelPorOperacao(operacao) - 1]) {
            nivelDaOperacao = usuario.getNivelPorOperacao(operacao);
            nivelDaOperacao++;
        }

        return nivelDaOperacao;
    }
}
