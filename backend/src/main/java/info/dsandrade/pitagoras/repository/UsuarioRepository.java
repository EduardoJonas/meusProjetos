package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNickAndDataNascimento(String nick, LocalDate dataNascimento);
    List<Usuario> findTop10ByOrderByPontosDesc();

    Optional<Usuario> findByNick(String nick);
}
