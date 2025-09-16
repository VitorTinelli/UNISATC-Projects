package vitor.tinelli.lista7.ex4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CinemaService {

    private final List<Filme> filmes = new ArrayList<>();

    public CinemaService() {
        inicializarFilmes();
    }

    private void inicializarFilmes() {
        filmes.add(Filme.builder()
                .id(UUID.randomUUID())
                .titulo("Vingadores: Ultimato")
                .genero("Ação")
                .capacidade(100)
                .assentosOcupados(0)
                .build());

        filmes.add(Filme.builder()
                .id(UUID.randomUUID())
                .titulo("Toy Story 4")
                .genero("Animação")
                .capacidade(80)
                .assentosOcupados(0)
                .build());

        filmes.add(Filme.builder()
                .id(UUID.randomUUID())
                .titulo("Coringa")
                .genero("Drama")
                .capacidade(120)
                .assentosOcupados(0)
                .build());
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    public Filme criarFilme(Filme filme) {
        filme.setId(UUID.randomUUID());
        filme.setAssentosOcupados(0);
        filmes.add(filme);
        return filme;
    }

    public Filme atualizarFilme(UUID id, Filme filmeAtualizado) {
        Filme filme = filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setCapacidade(filmeAtualizado.getCapacidade());

        return filme;
    }

    public void removerFilme(UUID id) {
        boolean removido = filmes.removeIf(f -> f.getId().equals(id));
        if (!removido) {
            throw new RuntimeException("Filme não encontrado");
        }
    }

    public Ingresso comprarIngresso(UUID filmeId) {
        Filme filme = filmes.stream()
                .filter(f -> f.getId().equals(filmeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (filme.getAssentosOcupados() >= filme.getCapacidade()) {
            throw new RuntimeException("Capacidade esgotada");
        }

        Integer numeroAssento = filme.getAssentosOcupados() + 1;

        Ingresso ingresso = Ingresso.builder()
                .ingressoId(UUID.randomUUID())
                .filmeId(filmeId)
                .assentoNumero(numeroAssento)
                .build();

        filme.getIngressos().add(ingresso);
        filme.setAssentosOcupados(filme.getAssentosOcupados() + 1);

        return ingresso;
    }

    public void devolverIngresso(UUID filmeId, UUID ingressoId) {
        Filme filme = filmes.stream()
                .filter(f -> f.getId().equals(filmeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        boolean removido = filme.getIngressos().removeIf(i -> i.getIngressoId().equals(ingressoId));

        if (!removido) {
            throw new RuntimeException("Ingresso não encontrado");
        }

        filme.setAssentosOcupados(filme.getAssentosOcupados() - 1);
    }
}
