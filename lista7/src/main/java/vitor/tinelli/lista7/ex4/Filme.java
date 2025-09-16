package vitor.tinelli.lista7.ex4;

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
public class Filme {
    private UUID id;
    private String titulo;
    private String genero;
    private Integer capacidade;
    private Integer assentosOcupados;

    @Builder.Default
    private List<Ingresso> ingressos = new ArrayList<>();
}
