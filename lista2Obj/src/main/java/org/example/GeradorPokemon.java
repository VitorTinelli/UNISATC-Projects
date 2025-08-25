package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeradorPokemon {

    private final Random random = new Random();

    private final List<String> nomesPokemon = Arrays.asList(
            "Pikachu", "Charizard", "Blastoise", "Venusaur", "Gengar", "Alakazam",
            "Machamp", "Golem", "Lapras", "Snorlax", "Dragonite", "Mewtwo",
            "Mew", "Gyarados", "Arcanine", "Rapidash", "Magnezone", "Lucario",
            "Garchomp", "Dialga", "Palkia", "Giratina", "Arceus", "Rayquaza"
            );

    private final List<String> tiposPokemon = Arrays.asList(
            "Elétrico", "Fogo", "Água", "Planta", "Fantasma", "Psíquico",
            "Lutador", "Terra", "Gelo", "Normal", "Dragão", "Voador",
            "Veneno", "Inseto", "Pedra", "Aço", "Sombrio", "Fada"
            );

    public String gerarPokemon() {
        String nome = nomesPokemon.get(random.nextInt(nomesPokemon.size()));
        String tipo = tiposPokemon.get(random.nextInt(tiposPokemon.size()));
        int nivel = 1 + random.nextInt(100);

        return String.format("%s é um Pokémon do tipo %s de nível %d.", nome, tipo, nivel);
    }

    public void chamarGerador(int quantidade) {
        System.out.println("Pokémon gerados:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + ". " + gerarPokemon());
        }
    }

    public void exec() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos Pokémon você deseja gerar? ");
        int quantidade = scanner.nextInt();
        chamarGerador(quantidade);
    }
}
