package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.servico.ServicoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private ServicoOperacao servicoOperacao;


    @GetMapping("/soma/{nivel}")
    public Operacao getSoma(@PathVariable int nivel) {
        Operacao soma = servicoOperacao.geraOperacaoSoma(nivel);
        return soma;
    }

    @GetMapping("/subtracao/{nivel}")
    public Operacao getSubtracao(@PathVariable int nivel) {
        Operacao subtracao = servicoOperacao.geraOperacaoSubtracao(nivel);
        return subtracao;
    }
}
