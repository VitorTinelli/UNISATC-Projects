package vitor.tinelli.primeira.ex4;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    public Playlist criarPlaylist(@RequestParam Long id, @RequestParam String nome) {
        return playlistService.criarPlaylist(id, nome);
    }

    @PostMapping("/{playlistId}/musicas")
    public Musica adicionarMusica(
            @PathVariable Long playlistId,
            @RequestBody Musica musica) {
        return playlistService.adicionarMusica(playlistId, musica);
    }

    @GetMapping
    public List<Playlist> listarPlaylists() {
        return playlistService.listarPlaylists();
    }

    @GetMapping("/{playlistId}/musicas")
    public List<Musica> listarMusicasPlaylist(@PathVariable Long playlistId) {
        return playlistService.listarMusicasPlaylist(playlistId);
    }

    @GetMapping("/{playlistId}")
    public Playlist obterPlaylist(@PathVariable Long playlistId) {
        return playlistService.obterPlaylist(playlistId);
    }
}
