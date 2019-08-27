package info.dsandrade.pitagoras.servico;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeraNumeroAleatorioImpl implements GeraNumeroAleatorio {

    @Override
    public int gerarNumeroAleatorio(int nivel) {
        switch (nivel) {
            case 1:  return new Random().nextInt((9 - 0) + 0);
            case 2:  return new Random().nextInt((20 - 0) + 0);
            case 3:  return new Random().nextInt((50 - 0) + 0);
            case 4:  return new Random().nextInt((99 - 0) + 0);
        }
        return 0;
    }
}
