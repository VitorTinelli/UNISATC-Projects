package vitor.tinelli.primeira.ex1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recomendador")
public class RecomendadorController {

    @GetMapping
    public String getRecomendacao(@RequestParam String clima, @RequestParam String estilo){
        if (clima.equals("frio") && estilo.equals("natureza")){
            return "Serra Gaúcha";
        } else if (clima.equals("frio") && estilo.equals("praia")){
            return "Balneário Camboriú";
        } else if (clima.equals("quente") && estilo.equals("natureza")){
            return "Chapada dos Veadeiros";
        } else if (clima.equals("quente") && estilo.equals("praia")){
            return "Fernando de Noronha";
        } else {
            return "Opção inválida. Por favor, escolha entre 'frio' ou 'quente' para clima e 'natureza' ou 'praia' para estilo.";
        }
    }
}
