package vitor.tinelli.repositories.api.Jogador;

import lombok.Data;

@Data
public class JogadorRequest {

    private String nome;
    private String sobrenome;
    private String posicao;
}
