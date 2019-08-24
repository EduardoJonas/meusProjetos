package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/ranking")
    public List<Usuario> getRanking() {
        List<Usuario> usuariosOrdenadoPorPontos = this.usuarioRepository.findByOrderByPontosDesc();
        return usuariosOrdenadoPorPontos;
    }
}
