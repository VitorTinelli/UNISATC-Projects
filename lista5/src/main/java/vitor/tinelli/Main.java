package vitor.tinelli;

import java.util.*;

import vitor.tinelli.barcos.Barco;
import vitor.tinelli.barcos.PortoGrande;
import vitor.tinelli.barcos.PortoPequeno;
import vitor.tinelli.personagem.Personagem;

public class Main {
    public static void main(String[] args) {

        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Goblin", 30, 5));
        inimigos.add(new Personagem("Orc", 50, 10));
        inimigos.add(new Personagem("Troll", 80, 12));

        Personagem jogador = new Personagem("Tinelli", 100, 30);
        Random random = new Random();

        while (jogador.getVida() > 0 && inimigos.stream().anyMatch(i -> i.getVida() > 0)) {
            List<Personagem> vivos = inimigos.stream().filter(i -> i.getVida() > 0).toList();
            if (!vivos.isEmpty()) {
                Personagem alvo = vivos.get(random.nextInt(vivos.size()));
                jogador.atacar(alvo);
            }
            for (Personagem inimigo : inimigos) {
                if (inimigo.getVida() > 0 && jogador.getVida() > 0) {
                    inimigo.atacar(jogador);
                }
            }
        }

        System.out.println("\nResultado final:");
        System.out.println(jogador.getNome() + " - Vida: " + jogador.getVida());
        for (Personagem inimigo : inimigos) {
            System.out.println(inimigo.getNome() + " - Vida: " + inimigo.getVida());
        }
        System.out.println("Vencedor: " + (jogador.getVida() > 0 ? jogador.getNome() : "Monstros"));

        //Barcos
        List<Barco> barcos = new ArrayList<>();
        barcos.add(new Barco("Barco 1", 2));
        barcos.add(new Barco("Barco 2", 5));
        barcos.add(new Barco("Barco 3", 7));
        barcos.add(new Barco("Barco 4", 12));
        barcos.add(new Barco("Barco 5", 20));

        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        for (Barco barco : barcos) {
            if (portoPequeno.atracarBarco(barco)) {
                System.out.println(barco.getNome() + " atracado no porto pequeno");
            } else if (portoGrande.atracarBarco(barco)) {
                System.out.println(barco.getNome() + " atracado no porto grande");
            } else {
                System.out.println(barco.getNome() + " não pôde ser atracado em nenhum porto");
            }
        }
    }
}