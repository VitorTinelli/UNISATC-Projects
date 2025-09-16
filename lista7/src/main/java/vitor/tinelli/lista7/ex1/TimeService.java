package vitor.tinelli.lista7.ex1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private final List<Jogador> jogadores = new ArrayList<>();

    public TimeService() {
        inicializarTime();
    }

    private void inicializarTime() {
        // Titulares (posições 0-10)
        jogadores.add(Jogador.builder().nome("João").posicao(0).idade(25).build()); // Goleiro
        jogadores.add(Jogador.builder().nome("Pedro").posicao(1).idade(23).build()); // Zagueiro
        jogadores.add(Jogador.builder().nome("Carlos").posicao(2).idade(27).build()); // Zagueiro
        jogadores.add(Jogador.builder().nome("Rafael").posicao(3).idade(24).build()); // Lateral
        jogadores.add(Jogador.builder().nome("Lucas").posicao(4).idade(26).build()); // Lateral
        jogadores.add(Jogador.builder().nome("André").posicao(5).idade(28).build()); // Volante
        jogadores.add(Jogador.builder().nome("Felipe").posicao(6).idade(25).build()); // Meio-campo
        jogadores.add(Jogador.builder().nome("Diego").posicao(7).idade(29).build()); // Meio-campo
        jogadores.add(Jogador.builder().nome("Gabriel").posicao(8).idade(22).build()); // Atacante
        jogadores.add(Jogador.builder().nome("Thiago").posicao(9).idade(30).build()); // Atacante
        jogadores.add(Jogador.builder().nome("Bruno").posicao(10).idade(24).build()); // Atacante

        // Reservas (posições 11-15)
        jogadores.add(Jogador.builder().nome("Marcos").posicao(11).idade(26).build());
        jogadores.add(Jogador.builder().nome("Paulo").posicao(12).idade(23).build());
        jogadores.add(Jogador.builder().nome("Ricardo").posicao(13).idade(27).build());
        jogadores.add(Jogador.builder().nome("Vinicius").posicao(14).idade(25).build());
        jogadores.add(Jogador.builder().nome("Rodrigo").posicao(15).idade(28).build());
    }

    public List<Jogador> listarTitulares() {
        return jogadores.stream()
                .filter(jogador -> jogador.getPosicao() <= 10)
                .toList();
    }

    public List<Jogador> listarReservas() {
        return jogadores.stream()
                .filter(jogador -> jogador.getPosicao() >= 11)
                .toList();
    }

    public Jogador substituirJogador(Integer posicao) {
        if (posicao < 0 || posicao > 10) {
            throw new RuntimeException("Posição deve estar entre 0 e 10");
        }

        List<Jogador> reservas = listarReservas();
        if (reservas.isEmpty()) {
            throw new RuntimeException("Não há reservas disponíveis");
        }

        // Pega o primeiro reserva disponível
        Jogador reserva = reservas.get(0);

        // Encontra o jogador titular na posição especificada
        Jogador titular = jogadores.stream()
                .filter(j -> j.getPosicao().equals(posicao))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado na posição: " + posicao));

        // Troca as posições
        Integer posicaoReserva = reserva.getPosicao();
        reserva.setPosicao(posicao);
        titular.setPosicao(posicaoReserva);

        return reserva; // Retorna o jogador que entrou
    }
}
