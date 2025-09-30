package vitor.tinelli.repositories.domain.jogador;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JogadorService {

    private final JogadorRepository repository;
    private final Random random = new Random();

    public List<JogadorEntity> getAllJogadores(){
        return (List<JogadorEntity>) repository.findAll();
    }

    public JogadorEntity saveJogador(String nome, String sobrenome, String posicao){
        JogadorEntity jogador = JogadorEntity.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .posicao(posicao)
                .clube("Criciuma")
                .idade(random.nextInt(18, 45))
                .build();
        return repository.save(jogador);
    }

    public JogadorEntity getJogadorById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador not found"));
    }

    public JogadorEntity deleteJogador(UUID id) {
        var jogadorToBeDeleted = getJogadorById(id);
        repository.delete(jogadorToBeDeleted);
        return jogadorToBeDeleted;
    }

    public JogadorEntity getJogadorByName(String name) {
        return repository.getJogadorEntityByNome(name)
                .orElseThrow(() -> new EntityNotFoundException("Jogador not found"));
    }
}
