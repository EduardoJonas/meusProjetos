package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
