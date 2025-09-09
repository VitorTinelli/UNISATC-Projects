package vitor.tinelli.primeira.ex3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudantes")
@RequiredArgsConstructor
public class EstudantesController {

    private final EstudantesService service;

    @GetMapping
    public List<Estudante> getEstudantes(){
        return service.getAllEstudantes();
    }

    @GetMapping("/{id}")
    public Estudante getEstudanteById(@PathVariable Integer id){
        return service.getEstudanteById(id);
    }

    @PostMapping
    public Estudante saveEstudante(@RequestBody Estudante estudante){
        return service.saveEstudante(estudante);
    }
}
