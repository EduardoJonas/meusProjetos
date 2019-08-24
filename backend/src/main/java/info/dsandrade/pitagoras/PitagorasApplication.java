package info.dsandrade.pitagoras;

import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class PitagorasApplication {
	private UsuarioRepository usuarioRepository;

	@Autowired
	public PitagorasApplication(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PitagorasApplication.class, args);
	}

	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {

		private final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
		@Override
		public void run(String...args) throws Exception {
			LocalDate meuNiver = LocalDate.now().of(1989, 7, 30);
			Usuario usuario = new Usuario("dsandrade0", "Diego Andrade", meuNiver);
			Optional<Usuario> usuarioPadrao = usuarioRepository.findByNickAndDataNascimento(usuario.getNick(), usuario.getDataNascimento());
			if (!usuarioPadrao.isPresent()) {
				usuarioRepository.save(usuario);
			}
		}
	}

}
