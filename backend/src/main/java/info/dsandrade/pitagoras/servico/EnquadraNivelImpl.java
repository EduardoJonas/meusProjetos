package info.dsandrade.pitagoras.servico;

import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.OperacaoRepository;
import info.dsandrade.pitagoras.repository.ResultadoTentativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnquadraNivelImpl implements EnquadraNivel {

    @Autowired
    private ResultadoTentativaRepository repositoryTentativa;
    @Autowired
    private OperacaoRepository repositoryOperacao;

    @Override
    public int verificaNivelSoma(Usuario usuario) {
        return proximoNivel(usuario, '+');
    }

    @Override
    public int verificaNivelSubtracao(Usuario usuario) {
        return proximoNivel(usuario, '-');
    }

    @Override
    public int verificaNivelMultiplicacao(Usuario usuario) {
        return proximoNivel(usuario, '*');
    }

    @Override
    public int verificaNivelDivisao(Usuario usuario) {
        return proximoNivel(usuario, '/');
    }

    @Override
    public int proximoNivel(Usuario usuario, char operacao) {
        int nivelDaOperacao = usuario.getNivelPorOperacao(operacao);
        LocalDateTime hoje = LocalDate.now().atTime(0, 0, 0);
        List<ResultadoTentativa> usuarioTentativasCorretas =
                repositoryTentativa.findByUsuarioAndDataHoraAfter(usuario, hoje);

        usuarioTentativasCorretas = usuarioTentativasCorretas
                .stream()
                .filter(tentativa -> tentativa.getOperacao().getOperacao() == operacao && tentativa.isCorreta())
                .collect(Collectors.toList());
        if (usuarioTentativasCorretas.size() > TROCA_NIVEL[usuario.getNivelPorOperacao(operacao) - 1]) {
            nivelDaOperacao = usuario.getNivelPorOperacao(operacao);
            nivelDaOperacao++;
        }
        return nivelDaOperacao;
    }
}
