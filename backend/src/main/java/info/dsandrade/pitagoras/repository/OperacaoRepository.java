package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Optional<Operacao> findByOperacao(char operacao);
}
