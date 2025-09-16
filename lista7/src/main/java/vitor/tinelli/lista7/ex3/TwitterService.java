package vitor.tinelli.lista7.ex3;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TwitterService {

    private final List<Usuario> usuarios = new ArrayList<>();

    public TwitterService() {
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        usuarios.add(Usuario.builder()
                .id(UUID.randomUUID())
                .nome("João Silva")
                .email("joao@email.com")
                .build());

        usuarios.add(Usuario.builder()
                .id(UUID.randomUUID())
                .nome("Maria Santos")
                .email("maria@email.com")
                .build());

        usuarios.add(Usuario.builder()
                .id(UUID.randomUUID())
                .nome("Pedro Oliveira")
                .email("pedro@email.com")
                .build());
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public List<Tweet> listarTweetsUsuario(UUID usuarioId) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuario.getTweets();
    }

    public Tweet criarTweet(UUID usuarioId, String mensagem) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tweet tweet = Tweet.builder()
                .tweetId(UUID.randomUUID())
                .mensagem(mensagem)
                .editado(false)
                .dataCriacao(LocalDateTime.now())
                .build();

        usuario.getTweets().add(tweet);
        return tweet;
    }

    public Tweet atualizarTweet(UUID usuarioId, UUID tweetId, String novaMensagem) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tweet tweet = usuario.getTweets().stream()
                .filter(t -> t.getTweetId().equals(tweetId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tweet não encontrado"));

        tweet.setMensagem(novaMensagem);
        tweet.setEditado(true);
        return tweet;
    }

    public void removerTweet(UUID usuarioId, UUID tweetId) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(usuarioId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean removido = usuario.getTweets().removeIf(t -> t.getTweetId().equals(tweetId));

        if (!removido) {
            throw new RuntimeException("Tweet não encontrado");
        }
    }
}
