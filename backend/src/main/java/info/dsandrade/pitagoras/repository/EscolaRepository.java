package info.dsandrade.pitagoras.repository;

import info.dsandrade.pitagoras.modelo.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    List<Escola> findByNome(String nome);
}
