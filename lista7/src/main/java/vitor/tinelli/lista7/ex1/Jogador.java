package vitor.tinelli.lista7.ex1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {
    private String nome;
    private Integer posicao;
    private Integer idade;
}
