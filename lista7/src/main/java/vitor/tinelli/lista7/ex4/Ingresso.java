package vitor.tinelli.lista7.ex4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {
    private UUID ingressoId;
    private UUID filmeId;
    private Integer assentoNumero;
}
