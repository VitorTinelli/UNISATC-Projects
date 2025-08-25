package vitor.tinelli.data;

public class DataTeste {
    public static void main(String[] args) {
        System.out.println("=== Teste da Classe Data ===\n");

        System.out.println("1. Testando datas válidas:");
        try {
            Data data1 = new Data(15, 8, 2025);
            System.out.print("Data 1: ");
            data1.displayData();

            Data data2 = new Data(29, 2, 2024); // Ano bissexto
            System.out.print("Data 2 (ano bissexto): ");
            data2.displayData();

            Data data3 = new Data(31, 12, 2023);
            System.out.print("Data 3: ");
            data3.displayData();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n2. Testando datas inválidas:");
        try {
            Data dataInvalida1 = new Data(15, 13, 2025);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        try {
            Data dataInvalida2 = new Data(0, 1, 2025);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
