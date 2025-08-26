package vitor.tinelli.barcos;

import java.util.ArrayList;
import java.util.List;

public class BasePorto {
    protected String nome;
    protected List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public boolean atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        return true;
    }

    public boolean desatracarBarco(Barco barco) {
        return barcosAtracados.remove(barco);
    }

    public String getNome() {
        return nome;
    }

    public List<Barco> getBarcosAtracados() {
        return barcosAtracados;
    }
}
