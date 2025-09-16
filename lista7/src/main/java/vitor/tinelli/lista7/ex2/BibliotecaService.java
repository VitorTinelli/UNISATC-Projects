package vitor.tinelli.lista7.ex2;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BibliotecaService {

    private final List<Livro> livrosDisponiveis = new ArrayList<>();
    private final List<Emprestimo> emprestimosAtivos = new ArrayList<>();

    public BibliotecaService() {
        inicializarLivros();
    }

    private void inicializarLivros() {
        livrosDisponiveis.add(Livro.builder()
                .id(UUID.randomUUID())
                .titulo("Dom Casmurro")
                .autor("Machado de Assis")
                .build());

        livrosDisponiveis.add(Livro.builder()
                .id(UUID.randomUUID())
                .titulo("O Cortiço")
                .autor("Aluísio Azevedo")
                .build());

        livrosDisponiveis.add(Livro.builder()
                .id(UUID.randomUUID())
                .titulo("1984")
                .autor("George Orwell")
                .build());

        livrosDisponiveis.add(Livro.builder()
                .id(UUID.randomUUID())
                .titulo("O Pequeno Príncipe")
                .autor("Antoine de Saint-Exupéry")
                .build());

        livrosDisponiveis.add(Livro.builder()
                .id(UUID.randomUUID())
                .titulo("Harry Potter e a Pedra Filosofal")
                .autor("J.K. Rowling")
                .build());
    }

    public List<Livro> listarLivrosDisponiveis() {
        return new ArrayList<>(livrosDisponiveis);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return new ArrayList<>(emprestimosAtivos);
    }

    public Emprestimo criarEmprestimo(UUID livroId, UUID usuarioId) {
        Livro livro = livrosDisponiveis.stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Livro não encontrado ou não disponível"));

        Emprestimo emprestimo = Emprestimo.builder()
                .emprestimoId(UUID.randomUUID())
                .livroId(livroId)
                .usuarioId(usuarioId)
                .dataEmprestimo(LocalDateTime.now())
                .build();

        emprestimosAtivos.add(emprestimo);
        livrosDisponiveis.remove(livro);

        return emprestimo;
    }

    public void devolverLivro(UUID emprestimoId) {
        Emprestimo emprestimo = emprestimosAtivos.stream()
                .filter(e -> e.getEmprestimoId().equals(emprestimoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        // Busca o livro original para devolver
        Livro livro = obterLivroPorId(emprestimo.getLivroId());

        emprestimosAtivos.remove(emprestimo);
        livrosDisponiveis.add(livro);
    }

    private Livro obterLivroPorId(UUID livroId) {
        // Reconstrói o livro baseado no ID (em um cenário real, seria buscado do banco)
        return emprestimosAtivos.stream()
                .filter(e -> e.getLivroId().equals(livroId))
                .findFirst()
                .map(e -> {
                    // Aqui normalmente buscaríamos do banco, mas vamos usar dados fictícios
                    return Livro.builder()
                            .id(livroId)
                            .titulo("Livro Devolvido")
                            .autor("Autor")
                            .build();
                })
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
