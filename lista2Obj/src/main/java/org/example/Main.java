package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LISTA 002 - Classe Random ===\n");

        System.out.println("1. GERADOR DE SENHAS");
        System.out.println("-------------------");
        GeradorSenha geradorSenha = new GeradorSenha();
        geradorSenha.exec();
        System.out.println();

        System.out.println("2. GERADOR DE JOGADOR");
        System.out.println("---------------------");
        GeradorJogador geradorJogador = new GeradorJogador();
        geradorJogador.exec();
        System.out.println();

        System.out.println("3. GERADOR DE POKÉMON");
        System.out.println("---------------------");
        GeradorPokemon geradorPokemon = new GeradorPokemon();
        geradorPokemon.exec();

        scanner.close();
    }
}