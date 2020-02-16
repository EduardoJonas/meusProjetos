package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ResultadoTentativaRepository extends JpaRepository<ResultadoTentativa, Long> {
    List<ResultadoTentativa> findByUsuario(Usuario usuario);

    List<ResultadoTentativa> findByUsuarioAndDataHoraAfter(Usuario usuario, LocalDateTime dataHora);
}
