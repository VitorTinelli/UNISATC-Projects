package vitor.tinelli.primeira.ex3;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Estudante {

    private Integer id;
    private String nome;
    private String curso;
    private String email;
    private String universidade;
}
