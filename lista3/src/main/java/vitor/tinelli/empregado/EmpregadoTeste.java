package vitor.tinelli.empregado;

public class EmpregadoTeste {

    public static void main(String[] args) {
        Empregado empregado = new Empregado("Vitor", "Tinelli", 3000);
        Empregado empregado2 = new Empregado("Ana", "Silva", 4500);
        printEmpregado(empregado);

        System.out.println();

        printEmpregado(empregado2);
    }

    private static void printEmpregado(Empregado empregado) {
        System.out.println("Nome: " + empregado.getNome());
        System.out.println("Sobrenome: " + empregado.getSobrenome());
        System.out.println("Salário Mensal: " + empregado.getSalarioMensal());
        System.out.println("Salário Anual: " + empregado.getSalarioAnual());
        System.out.println();
        System.out.println("Salário com aumento de 10%: " + (empregado.getSalarioMensal() * 1.1 * 13));
    }
}
