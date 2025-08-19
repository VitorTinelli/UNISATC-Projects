package org.example;

import org.example.classes.Jogador;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] nomes = {"Cesar", "Paulo", "Vitor", "Lucas", "Pedro"};
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Tinelli"};
        String[] posicoes = {"Goleiro", "Zagueiro", "Meio-campo", "Atacante"};
        String[] times = {"Flamengo", "Palmeiras", "Santos", "Vasco", "Criciuma"};

        Random random = new Random();

        for (int i = 0; i < 11; i++){
             Jogador jogador = new Jogador(
                    nomes[random.nextInt(nomes.length)],
                    sobrenomes[random.nextInt(sobrenomes.length)],
                    posicoes[random.nextInt(posicoes.length)],
                    times[random.nextInt(times.length)]
             );

            System.out.println("Jogador " + (i + 1) + ": " + jogador.nome + " " + jogador.sobrenome +
                    ", Posicao: " + jogador.posicao + ", Time: " + jogador.time);
        }
    }
}