package vitor.tinelli.lista7.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @GetMapping("/livros")
    public List<Livro> listarLivrosDisponiveis() {
        return bibliotecaService.listarLivrosDisponiveis();
    }

    @GetMapping("/emprestados")
    public List<Emprestimo> listarEmprestimosAtivos() {
        return bibliotecaService.listarEmprestimosAtivos();
    }

    @PostMapping("/emprestados")
    public Emprestimo criarEmprestimo(@RequestParam UUID livroId, @RequestParam UUID usuarioId) {
        return bibliotecaService.criarEmprestimo(livroId, usuarioId);
    }

    @DeleteMapping("/emprestados/{emprestimoId}")
    public void devolverLivro(@PathVariable UUID emprestimoId) {
        bibliotecaService.devolverLivro(emprestimoId);
    }
}
