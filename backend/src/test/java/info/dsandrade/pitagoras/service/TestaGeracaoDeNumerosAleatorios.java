package info.dsandrade.pitagoras.service;

import info.dsandrade.pitagoras.servico.GeraNumeroAleatorioImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestaGeracaoDeNumerosAleatorios {

    private GeraNumeroAleatorioImpl geradorDeNumeros;

    @Before
    public void configuracao() {
        this.geradorDeNumeros = new GeraNumeroAleatorioImpl();
        
    }

    private List<Integer> numerosGerados(int nivel) {
        List<Integer> listaNumeros =
                IntStream.range(0, 1000)
                        .map(i -> geradorDeNumeros.gerarNumeroAleatorio(nivel))
                        .boxed()
                        .collect(Collectors.toList());
        return listaNumeros;
    }

    @Test
    public void geraNumerosRandomicosDeUmADez() {
        List<Integer> listaNumerosNivelUm = numerosGerados(1);
        assertThat(listaNumerosNivelUm).containsOnlyElementsOf(
                IntStream.range(0, 9)
                        .boxed()
                        .collect(Collectors.toList()));
    }

    @Test
    public void geraNumerosRandomicosDeZeroAVinte() {
        List<Integer> listaNumerosNivelDois = numerosGerados(2);
        assertThat(listaNumerosNivelDois).containsOnlyElementsOf(
                IntStream.range(0, 20)
                        .boxed()
                        .collect(Collectors.toList()));
    }

    @Test
    public void geraNumerosRandomicosDeZeroACinquenta() {
        List<Integer> listaNumerosNivelDois = numerosGerados(3);
        assertThat(listaNumerosNivelDois).containsOnlyElementsOf(
                IntStream.range(0, 50)
                        .boxed()
                        .collect(Collectors.toList()));
    }

    @Test
    public void geraNumerosRandomicosDeZeroANoveNove() {
        List<Integer> listaNumerosNivelDois = numerosGerados(4);
        assertThat(listaNumerosNivelDois).containsOnlyElementsOf(
                IntStream.range(0, 99)
                        .boxed()
                        .collect(Collectors.toList()));
    }
}
