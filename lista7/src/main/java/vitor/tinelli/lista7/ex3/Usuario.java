package vitor.tinelli.lista7.ex3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private UUID id;
    private String nome;
    private String email;

    @Builder.Default
    private List<Tweet> tweets = new ArrayList<>();
}
