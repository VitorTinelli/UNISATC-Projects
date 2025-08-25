package org.example;

import java.util.Random;

public class GeradorSenha {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final Random random = new Random();

    public String gerarSenha(int tamanho) {
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(indice));
        }

        return senha.toString();
    }

    public void exec() {
        String senha = gerarSenha(8);
        System.out.println("Senha gerada: " + senha);
    }
}
