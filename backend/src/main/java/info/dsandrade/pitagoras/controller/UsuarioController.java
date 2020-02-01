package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.EscolaRepository;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    private EscolaRepository escolaRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, EscolaRepository escolaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.escolaRepository = escolaRepository;
    }

    @GetMapping("/ranking")
    public List<Usuario> getRanking() {
        List<Usuario> usuariosOrdenadoPorPontos = this.usuarioRepository.findTop10ByOrderByPontosDesc();
        return usuariosOrdenadoPorPontos;
    }

    @PostMapping("/login")
    public Usuario getLogin(
            @RequestParam("nick") String nick,
            @RequestParam("nascimento") String nascimento) {

        String[] partesNascimento = nascimento.split("/");
        LocalDate dataNascimento =
            LocalDate.of(
                Integer.parseInt(partesNascimento[2]),
                Integer.parseInt(partesNascimento[1]),
                Integer.parseInt(partesNascimento[0]));
        Optional<Usuario> usuario = usuarioRepository.findByNickAndDataNascimento(nick.trim(), dataNascimento);
        return usuario.orElseGet(null);
    }

    @PostMapping("/novo")
    public void novo(
        String nome,
        String data,
        Long escola,
        String nick) {
        Optional<Usuario> teste = usuarioRepository.findByNick(nick);
        if (teste.isPresent()) {
            throw new IllegalArgumentException("O nick ja foi utilizado");
        }

        String[] partesData = data.split("/");
        LocalDate dataNascimento =
            LocalDate.of(
                Integer.parseInt(partesData[2]),
                Integer.parseInt(partesData[1]),
                Integer.parseInt(partesData[0])
            );
        Usuario usuario = new Usuario(nick, nome, dataNascimento);
        usuario.setPontos(0L);
        usuario.setNivelSoma(1);
        usuario.setNivelSubtracao(1);
        usuario.setNivelMultiplicacao(1);
        usuario.setNivelDivisao(1);
        usuario.setEscola(escolaRepository.findById(escola).get());
        usuarioRepository.save(usuario);


    }

}
