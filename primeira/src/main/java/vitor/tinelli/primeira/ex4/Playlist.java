package vitor.tinelli.primeira.ex4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    private Long id;
    private String nome;

    @Builder.Default
    private List<Musica> musicas = new ArrayList<>();
}
