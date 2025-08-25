package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeradorJogador {
    private final Random random = new Random();

    private final List<String> nomes = Arrays.asList(
            "Cássio", "Gabriel", "Lucas", "Pedro", "João", "Gustavo", "Rafael", "Bruno",
            "Diego", "Felipe", "Matheus", "Vinicius", "Arthur", "Henrique", "Daniel"
            );

    private final List<String> sobrenomes = Arrays.asList(
            "Ramos", "Silva", "Santos", "Oliveira", "Souza", "Costa", "Pereira", "Alves",
            "Ferreira", "Rodrigues", "Gomes", "Martins", "Barbosa", "Ribeiro", "Araújo"
            );

    private final List<String> posicoes = Arrays.asList(
            "goleiro", "zagueiro", "lateral-direito", "lateral-esquerdo", "volante",
            "meio-campista", "atacante", "ponta-direita", "ponta-esquerda", "centroavante"
            );

    private final List<String> times = Arrays.asList(
            "Corinthians", "Palmeiras", "São Paulo", "Santos", "Flamengo", "Fluminense",
            "Vasco", "Botafogo", "Grêmio", "Internacional", "Atlético-MG", "Cruzeiro"
            );

    public String gerarJogador() {
        String nome = nomes.get(random.nextInt(nomes.size()));
        String sobrenome = sobrenomes.get(random.nextInt(sobrenomes.size()));
        int idade = 16 + random.nextInt(30);
        String posicao = posicoes.get(random.nextInt(posicoes.size()));
        String time = times.get(random.nextInt(times.size()));

        return String.format("%s %s é um futebolista brasileiro de %d anos que atua como %s. Atualmente defende o %s.",
                nome, sobrenome, idade, posicao, time);
    }

    public void exec() {
        System.out.println(gerarJogador());
    }
}
