package vitor.tinelli.data;

import java.time.Year;

public class Data {
    private int mes;
    private int dia;
    private int ano;

    public Data(int dia, int mes, int ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    private int getDiasNoMes(int mes, int ano) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> Year.isLeap(ano) ? 29 : 28;
            default -> 0;
        };
    }

    public void displayData() {
        System.out.printf("%02d/%02d/%d%n", dia, mes, ano);
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAno() {
        return ano;
    }

    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês deve estar entre 1 e 12. Valor informado: " + mes);
        }
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDia(int dia) {
        int diasNoMes = getDiasNoMes(mes, ano);
        if (dia < 1 || dia > diasNoMes) {
            throw new IllegalArgumentException("Dia deve estar entre 1 e " + diasNoMes + " para o mês " + mes + ". Valor informado: " + dia);
        }
        this.dia = dia;
    }

}
