package vitor.tinelli.lista7.ex2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private UUID id;
    private String titulo;
    private String autor;
}
