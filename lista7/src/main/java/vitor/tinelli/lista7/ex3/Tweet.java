package vitor.tinelli.lista7.ex3;

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
public class Tweet {
    private UUID tweetId;
    private String mensagem;
    private boolean editado;
    private LocalDateTime dataCriacao;
}
