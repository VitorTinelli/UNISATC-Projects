package vitor.tinelli.lista7.ex4;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping
    public List<Filme> listarFilmes() {
        return cinemaService.listarFilmes();
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return cinemaService.criarFilme(filme);
    }

    @PatchMapping("/{id}")
    public Filme atualizarFilme(@PathVariable UUID id, @RequestBody Filme filme) {
        return cinemaService.atualizarFilme(id, filme);
    }

    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable UUID id) {
        cinemaService.removerFilme(id);
    }

    @PostMapping("/{id}/ingressos")
    public Ingresso comprarIngresso(@PathVariable UUID id) {
        return cinemaService.comprarIngresso(id);
    }

    @DeleteMapping("/{id}/ingressos/{ingressoId}")
    public void devolverIngresso(@PathVariable UUID id, @PathVariable UUID ingressoId) {
        cinemaService.devolverIngresso(id, ingressoId);
    }
}
