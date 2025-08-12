package org.example;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade < 12) {
            System.out.println("Categoria: Infantil");
        } else if (idade >= 12 && idade <= 17) {
            System.out.println("Categoria: Adolescente");
        } else {
            System.out.println("Categoria: Adulto");
        }

        scanner.close();
    }
}
