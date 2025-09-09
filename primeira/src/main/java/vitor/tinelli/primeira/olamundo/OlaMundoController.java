package vitor.tinelli.primeira.olamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    @GetMapping
    public String olaMundo(@RequestParam String nome) {
        return "Olá, Mundo! Seja bem-vindo, " + nome + "!";
    }
}
