package vitor.tinelli.lista09.fipe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("fipe")
public class FipeController {

    private static final FipeService service = new FipeService();

    @GetMapping
    public FipeResponse getFipe(@RequestBody FipeRequest fipeRequest) {
        String codigoMarca = service.getMarcaId(fipeRequest.getMarca());
        String codigoModelo = service.getModeloId(codigoMarca, fipeRequest.getModelo());
        return service.getValorFipe(codigoMarca, codigoModelo, fipeRequest.getAno());
    }
}
