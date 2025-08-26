package vitor.tinelli.personagem;

public class Personagem {

    private String nome;
    private int vida;
    private int ataque;

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        if (this.vida == 0) {
            System.out.println(this.nome + " foi derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        if (alvo.getVida() <= 0) {
            System.out.println(alvo.getNome() + " já está derrotado!");
            return;
        }
        System.out.println(this.nome + " atacou " + alvo.getNome() + " causando " + this.ataque + " de dano.");
        alvo.receberDano(this.ataque);
    }

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
