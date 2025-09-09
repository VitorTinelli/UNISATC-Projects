package vitor.tinelli.primeira.ex2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JogadorService {
    public Jogador generatePlayer(String time, String posicao){

        List<String> nomes = List.of("Vitor", "Gustavo", "João", "Pedro", "Lucas");
        List<String> sobrenomes = List.of("Tinelli", "Silva", "Santos", "Oliveira", "Souza");
        Random random = new Random();

        return Jogador.builder()
                .nome(nomes.get(random.nextInt(nomes.size())))
                .sobrenome(sobrenomes.get(random.nextInt(sobrenomes.size())))
                .idade(random.nextInt(16, 41))
                .time(time)
                .posicao(posicao)
                .build();
    }
}
