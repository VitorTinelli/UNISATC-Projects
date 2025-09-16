package vitor.tinelli.lista7.ex2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    private UUID emprestimoId;
    private UUID livroId;
    private UUID usuarioId;
    private LocalDateTime dataEmprestimo;
}
