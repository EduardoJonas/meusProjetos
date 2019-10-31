package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Escola;
import info.dsandrade.pitagoras.repository.EscolaRepository;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
@CrossOrigin("*")
public class EscolaController {

    @Autowired
    private EscolaRepository escolaRepository;

    @GetMapping("/todas")
    public List<Escola> getAll() {
        return escolaRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public void cadastrar(String nome) throws DuplicateMemberException {
        List<Escola> escolasPorNome = escolaRepository.findByNome(nome);
        if (escolasPorNome.size() > 0) {
            throw new DuplicateMemberException("Escola já cadastrada");
        }

        Escola escola = new Escola();
        escola.setNome(nome);
        escolaRepository.save(escola);
    }
}
