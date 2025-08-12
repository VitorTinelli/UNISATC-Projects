package org.example;


public class Ex3 {
    public static void main(String[] args) {
        String nome = "Teclado";
        int codigo = 12345;
        double preco = 99.90;
        boolean promocao = true;

        System.out.println("Produto: " + nome);
        System.out.println("Codigo: " + codigo);
        System.out.printf("Preco: R$ %.2f%n", preco);
        System.out.println("Promocao: " + promocao);
    }
}
