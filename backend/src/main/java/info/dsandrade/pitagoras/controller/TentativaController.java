package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.OperacaoRepository;
import info.dsandrade.pitagoras.repository.ResultadoTentativaRepository;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import info.dsandrade.pitagoras.servico.EnquadraNivel;
import info.dsandrade.pitagoras.servico.ServicoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TentativaController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private ResultadoTentativaRepository resultadoTentativaRepository;
    @Autowired
    private ServicoOperacao servicoOperacao;
    @Autowired
    private EnquadraNivel enquadraNivel;

    @PostMapping("/tentativa")
    public ResultadoTentativa getTentativa(
            @RequestParam("idUsuario") Long idUsuario,
            @RequestParam("idOperacao") Long idOperacao,
            @RequestParam("valorTentativa") int valorTentativa,
            @RequestParam("tempo") int tempo) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        Optional<Operacao> operacaoOptional = operacaoRepository.findById(idOperacao);

        if (usuarioOptional.isPresent() && operacaoOptional.isPresent()) {
            ResultadoTentativa tentativa = new ResultadoTentativa(usuarioOptional.get(), operacaoOptional.get(), valorTentativa);
            resultadoTentativaRepository.save(tentativa);
            boolean correta = servicoOperacao.checaTentativa(tentativa);
            tentativa.setCorreta(correta);
            if (correta) {
                Usuario usuario = usuarioOptional.get();
                Long pontos = usuario.getPontos();
                pontos += calculaPontos(operacaoOptional.get(), usuario);;
                usuario.setPontos(pontos);
                usuarioRepository.save(usuario);
            }
            return tentativa;
        }
        return null;
    }

    private Long calculaPontos(Operacao operacao, Usuario usuario) {
        char op = operacao.getOperacao();
        Long pontosOperacao;
        int nivelOperacao;
        int novoNivel;
        switch (op) {
            case '+':
                pontosOperacao = 2L;
                nivelOperacao = usuario.getNivelSoma();
                 novoNivel = enquadraNivel.verificaNivelSoma(usuario);
                 usuario.setNivelSoma(novoNivel);
                break;
            case '-':
                pontosOperacao = 2L;
                nivelOperacao = usuario.getNivelSubtracao();
                novoNivel = enquadraNivel.verificaNivelSubtracao(usuario);
                usuario.setNivelSubtracao(novoNivel);
                break;
            case '*':
                pontosOperacao = 4L;
                nivelOperacao = usuario.getNivelMultiplicacao();
                novoNivel = enquadraNivel.verificaNivelMultiplicacao(usuario);
                usuario.setNivelMultiplicacao(novoNivel);
                break;
            case '/':
                pontosOperacao = 4L;
                nivelOperacao = usuario.getNivelDivisao();
                novoNivel = enquadraNivel.verificaNivelDivisao(usuario);
                usuario.setNivelDivisao(novoNivel);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }

        usuarioRepository.save(usuario);
        return pontosOperacao * nivelOperacao;
    }
}
