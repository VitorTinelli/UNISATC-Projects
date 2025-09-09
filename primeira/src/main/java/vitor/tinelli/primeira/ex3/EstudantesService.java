package vitor.tinelli.primeira.ex3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstudantesService {

    private final EstudantesRepository repository;

    public Estudante getEstudanteById(Integer id) {
        log.info("getEstudanteById: {}", id);
        return repository.getEstudanteById(id);
    }

    public List<Estudante> getAllEstudantes() {
        return repository.getAllEstudantes();
    }

    public Estudante saveEstudante(Estudante estudante) {
        return repository.saveEstudante(estudante);
    }

}
