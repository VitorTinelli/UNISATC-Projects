package vitor.tinelli.primeira.ex2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Jogador {
    private String nome;
    private String sobrenome;
    private int  idade;
    private String time;
    private String posicao;
}
