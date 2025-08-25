package vitor.tinelli.fatura;

public class FaturaTeste {

    public static void main(String[] args) {
        Fatura fatura = new Fatura("001", "Caneta", 10, 2.5);
        printFatura(fatura);

        System.out.println();

        Fatura faturaNegativa = new Fatura("002", "Lápis", -5, -1.0);
        printFatura(faturaNegativa);

    }

    private static void printFatura(Fatura fatura) {
        System.out.println("Número: " + fatura.getNumero());
        System.out.println("Descrição: " + fatura.getDescricao());
        System.out.println("Quantidade: " + fatura.getQuantidade());
        System.out.println("Preço: " + fatura.getPreco());
        System.out.println("Valor da Fatura: " + fatura.getValorFatura());

    }
}
