package vitor.tinelli.primeira.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService service;

    @PostMapping("/{time}/{posicao}")
    public Jogador generateJogador(@PathVariable String time, @PathVariable String posicao){
        return service.generatePlayer(time, posicao);
    }

}
