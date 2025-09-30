package vitor.tinelli.repositories.api.Jogador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vitor.tinelli.repositories.domain.jogador.JogadorEntity;
import vitor.tinelli.repositories.domain.jogador.JogadorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService service;

    @GetMapping("/all")
    public List<JogadorEntity> getAllJogadores(){
        return service.getAllJogadores();
    }

    @GetMapping
    public JogadorEntity getJogadorById(@RequestParam UUID id){
        return service.getJogadorById(id);
    }

    @GetMapping("/{name}")
    public JogadorEntity getJogadorByName(@PathVariable String name){
        return service.getJogadorByName(name);
    }

    @PostMapping
    public JogadorEntity saveJogador(@RequestBody JogadorRequest jogador){
        return service.saveJogador(jogador.getNome(), jogador.getSobrenome(), jogador.getPosicao());
    }

    @DeleteMapping
    public JogadorEntity deleteJogador(@RequestParam UUID id){
         return service.deleteJogador(id);
    }
}
