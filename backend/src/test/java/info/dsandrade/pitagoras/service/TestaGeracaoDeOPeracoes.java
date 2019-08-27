package info.dsandrade.pitagoras.service;

import info.dsandrade.pitagoras.modelo.Operacao;
import info.dsandrade.pitagoras.modelo.ResultadoTentativa;
import info.dsandrade.pitagoras.modelo.Usuario;
import info.dsandrade.pitagoras.servico.GeraNumeroAleatorioImpl;
import info.dsandrade.pitagoras.servico.ServicoOperacao;
import info.dsandrade.pitagoras.servico.ServicoOperacaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class TestaGeracaoDeOPeracoes {

    @Mock
    private GeraNumeroAleatorioImpl geradorNumeros;
    private ServicoOperacao servicoOperacao;

    @Before
    public void configuracao() {
        MockitoAnnotations.initMocks(this);
        //this.geradorNumeros = new GeraNumeroAleatorioImpl();
        this.servicoOperacao = new ServicoOperacaoImpl(this.geradorNumeros);
    }

    @Test
    public void geraOperacaoDeSomaNivelUm() {
        Operacao soma = this.servicoOperacao.geraOperacaoSoma(1);
        assertThat(soma.getOperacao()).isEqualTo('+');
        assertThat(soma.getFatorA()).isBetween(0, 9);
        assertThat(soma.getFatorB()).isBetween(0, 9);
    }

    @Test
    public void geraOperacaoDeSubtracaoNivelUm() {
        Operacao subtracao = this.servicoOperacao.geraOperacaoSubtracao(1);
        assertThat(subtracao.getOperacao()).isEqualTo('-');
        assertThat(subtracao.getFatorA()).isBetween(0, 9);
        assertThat(subtracao.getFatorB()).isBetween(0, 9);
    }

    @Test
    public void checaTentativaCerta() {
        given(this.geradorNumeros.gerarNumeroAleatorio(1)).willReturn(1, 3);
        Operacao soma = this.servicoOperacao.geraOperacaoSoma(1);
        Usuario diego = new Usuario("dsandrade0", "Diego", LocalDate.of(1989, 7, 30));
        ResultadoTentativa tentativa = new ResultadoTentativa(diego, soma, 2);
        assertThat(this.servicoOperacao.checaTentativa(tentativa)).isFalse();

    }
}
