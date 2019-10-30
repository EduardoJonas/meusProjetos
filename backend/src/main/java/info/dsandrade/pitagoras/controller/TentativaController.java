package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.OperacaoRepository;
import info.dsandrade.pitagoras.repository.ResultadoTentativaRepository;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import info.dsandrade.pitagoras.servico.ServicoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TentativaController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private ResultadoTentativaRepository resultadoTentativaRepository;
    @Autowired
    private ServicoOperacao servicoOperacao;

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
                pontos += (tempo * operacaoOptional.get().getNivel());
                usuario.setPontos(pontos);
                usuarioRepository.save(usuario);
            }
            return tentativa;
        }
        return null;
    }
}
