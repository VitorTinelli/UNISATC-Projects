package vitor.tinelli.lista7.ex1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping("/principal")
    public List<Jogador> listarTitulares() {
        return timeService.listarTitulares();
    }

    @GetMapping("/reservas")
    public List<Jogador> listarReservas() {
        return timeService.listarReservas();
    }

    @PutMapping("/jogador/{posicao}")
    public Jogador substituirJogador(@PathVariable Integer posicao) {
        return timeService.substituirJogador(posicao);
    }
}
