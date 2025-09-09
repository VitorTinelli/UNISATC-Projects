package vitor.tinelli.primeira.ex3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudantesRepository {

    List<Estudante> estudantes = new ArrayList<>();

    public Estudante getEstudanteById(Integer id) {
        for (Estudante estudante : estudantes) {
            if (estudante.getId() == id) {
                return estudante;
            }
        }
        throw new RuntimeException("Estudante não encontrado");
    }

    public List<Estudante> getAllEstudantes() {
        return estudantes;
    }

    public Estudante saveEstudante(Estudante estudante) {
        estudantes.add(estudante);
        return estudante;
    }
}
