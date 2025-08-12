package org.example;

import java.util.Scanner;


public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor total da compra: R$ ");
        double valorCompra = scanner.nextDouble();

        double valorFinal;

        if (valorCompra > 100) {
            valorFinal = valorCompra * 0.9;
            System.out.printf("Valor final com desconto: R$ " + valorFinal);
        } else {
            valorFinal = valorCompra;
            System.out.printf("Valor final sem desconto: R$ " + valorFinal);
        }

        scanner.close();
    }
}
