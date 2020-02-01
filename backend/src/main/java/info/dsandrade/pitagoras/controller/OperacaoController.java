package info.dsandrade.pitagoras.controller;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.repository.OperacaoRepository;
import info.dsandrade.pitagoras.servico.ServicoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operacao")
@CrossOrigin("*")
public class OperacaoController {

    @Autowired
    private ServicoOperacao servicoOperacao;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @GetMapping("/soma/{nivel}")
    public Operacao getSoma(@PathVariable int nivel) {
        Operacao soma = servicoOperacao.geraOperacaoSoma(nivel);
        salvaOperacao(soma);
        return soma;
    }

    @GetMapping("/subtracao/{nivel}")
    public Operacao getSubtracao(@PathVariable int nivel) {
        Operacao subtracao = servicoOperacao.geraOperacaoSubtracao(nivel);
        salvaOperacao(subtracao);
        return subtracao;
    }

    @GetMapping("/multiplicacao/{nivel}")
    public Operacao getMultiplicacao(@PathVariable int nivel) {
        Operacao multiplicacao = servicoOperacao.geraOperacaoMultiplicacao(nivel);

        salvaOperacao(multiplicacao);
        return multiplicacao;
    }

    @GetMapping("/divisao/{nivel}")
    public Operacao getDivisao(@PathVariable int nivel) {
        Operacao divisao = servicoOperacao.geraOperacaoDivisao(nivel);
        salvaOperacao(divisao);
        return divisao;
    }

    @GetMapping("/operacoes")
    public List<Operacao> getOperacoesGeradas() {
        return operacaoRepository.findAll();
    }

    private void salvaOperacao(Operacao operacao) {
        operacaoRepository.save(operacao);
    }
}
