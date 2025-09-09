package vitor.tinelli.primeira.ex4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private final List<Playlist> playlists = new ArrayList<>();

    public Playlist criarPlaylist(Long id, String nome) {
        if (playlists.stream().anyMatch(p -> p.getId().equals(id))) {
            throw new RuntimeException("Playlist com ID " + id + " já existe");
        }

        Playlist playlist = Playlist.builder()
                .id(id)
                .nome(nome)
                .build();
        playlists.add(playlist);
        return playlist;
    }

    public Musica adicionarMusica(Long playlistId, Musica musica) {
        Playlist playlist = playlists.stream()
                .filter(p -> p.getId().equals(playlistId))
                .findFirst()
                .orElse(null);

        if (playlist == null) {
            throw new RuntimeException("Playlist não encontrada com ID: " + playlistId);
        }

        if (musica.getId() == null) {
            throw new RuntimeException("ID da música é obrigatório");
        }

        playlist.getMusicas().add(musica);
        return musica;
    }

    public List<Playlist> listarPlaylists() {
        return new ArrayList<>(playlists);
    }

    public List<Musica> listarMusicasPlaylist(Long playlistId) {
        Playlist playlist = playlists.stream()
                .filter(p -> p.getId().equals(playlistId))
                .findFirst()
                .orElse(null);

        if (playlist == null) {
            throw new RuntimeException("Playlist não encontrada com ID: " + playlistId);
        }
        return playlist.getMusicas();
    }

    public Playlist obterPlaylist(Long playlistId) {
        return playlists.stream()
                .filter(p -> p.getId().equals(playlistId))
                .findFirst()
                .orElse(null);
    }
}
