package test;
import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.Usuario;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    @Test
    public void testaBibliotecaTest() {

        Biblioteca biblioteca = new Biblioteca();

        Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
        Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);

        Usuario u1 = new Usuario("U001", "Carlos");
        Usuario u2 = new Usuario("U002", "Ana");

        biblioteca.cadastrarLivro(l1);
        biblioteca.cadastrarLivro(l2);

        biblioteca.cadastrarUsuario(u1);
        biblioteca.cadastrarUsuario(u2);

        // Emprestar livro
        biblioteca.emprestarLivro("L001", "U001");

        // Verifica se não está mais disponível
        boolean encontrado = biblioteca.livrosDisponiveis()
                .stream()
                .anyMatch(l -> l.getCodigo().equals("L001"));

        if (encontrado) {
            Assert.fail("Livro não deveria estar disponível");
        }

        // Tentar emprestar novamente
        biblioteca.emprestarLivro("L001", "U002");

        // Continua indisponível
        long quantidade = biblioteca.livrosDisponiveis()
                .stream()
                .filter(l -> l.getCodigo().equals("L001"))
                .count();

        Assert.assertEquals(0, quantidade);

        // Devolver livro
        biblioteca.devolverLivro("L001");

        boolean voltou = biblioteca.livrosDisponiveis()
                .stream()
                .anyMatch(l -> l.getCodigo().equals("L001"));

        if (!voltou) {
            Assert.fail("Livro deveria estar disponível após devolução");
        }

        // Devolver novamente (não deve dar erro)
        biblioteca.devolverLivro("L001");

        boolean aindaDisponivel = biblioteca.livrosDisponiveis()
                .stream()
                .anyMatch(l -> l.getCodigo().equals("L001"));

        Assert.assertTrue(aindaDisponivel);
    }
}