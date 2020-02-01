package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoTentativaRepository extends JpaRepository<ResultadoTentativa, Long> {
    List<ResultadoTentativa> findByUsuario(Usuario usuario);
    List<ResultadoTentativa> findByUsuarioAndCorretaIsTrue(Usuario usuario);
}
