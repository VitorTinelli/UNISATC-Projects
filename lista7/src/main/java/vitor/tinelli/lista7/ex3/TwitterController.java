package vitor.tinelli.lista7.ex3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class TwitterController {

    private final TwitterService twitterService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return twitterService.listarUsuarios();
    }

    @GetMapping("/{id}/tweets")
    public List<Tweet> listarTweetsUsuario(@PathVariable UUID id) {
        return twitterService.listarTweetsUsuario(id);
    }

    @PostMapping("/{id}/tweets")
    public Tweet criarTweet(@PathVariable UUID id, @RequestParam String mensagem) {
        return twitterService.criarTweet(id, mensagem);
    }

    @PatchMapping("/{id}/tweets/{tweetId}")
    public Tweet atualizarTweet(
            @PathVariable UUID id,
            @PathVariable UUID tweetId,
            @RequestParam String mensagem) {
        return twitterService.atualizarTweet(id, tweetId, mensagem);
    }

    @DeleteMapping("/{id}/tweets/{tweetId}")
    public void removerTweet(@PathVariable UUID id, @PathVariable UUID tweetId) {
        twitterService.removerTweet(id, tweetId);
    }
}
