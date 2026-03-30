package test;

import main.biblioteca.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BibliotecaTest {

    @Test
    public void testaCadastro() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);
            Usuario u1 = new Usuario("U001", "Carlos");

            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarLivro(l2);

            biblioteca.cadastrarUsuario(u1);

            try {
                biblioteca.cadastrarLivro(l1);
                Assert.fail("Deveria lançar exceção");
            } catch (LivroJaExisteException e) {}

            try {
                biblioteca.cadastrarUsuario(u1);
                Assert.fail("Deveria lançar exceção");
            } catch (UsuarioJaExisteException e) {}

        } catch (Exception e) {
            Assert.fail("Falha no cadastro: " + e.getMessage());
        }
    }

    @Test
    public void testaEmprestimoDevolucao() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Usuario u1 = new Usuario("U001", "Carlos");

            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarUsuario(u1);

            biblioteca.emprestarLivro("L001", "U001");

            boolean emprestado = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L001"));
            Assert.assertFalse(emprestado);

            biblioteca.devolverLivro("L001");

            boolean devolvido = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L001"));
            Assert.assertTrue(devolvido);

        } catch (Exception e) {
            Assert.fail("Falha no empréstimo/devolução: " + e.getMessage());
        }
    }

    @Test
    public void testaPesquisa() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);
            Livro l3 = new Livro("L003", "Estruturas de Dados", "João Silva", 40.0, false);

            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarLivro(l2);
            biblioteca.cadastrarLivro(l3);

            List<Livro> livrosJoao = biblioteca.pesquisarLivrosDoAutor("João Silva");
            Assert.assertEquals(2, livrosJoao.size());

            try {
                biblioteca.pesquisarLivrosDoAutor("Autor Inexistente");
                Assert.fail("Deveria lançar exceção");
            } catch (LivroNaoExisteException e) {}

            Livro maisBarato = biblioteca.livroMaisBarato();
            Assert.assertEquals("L003", maisBarato.getCodigo());

            List<Livro> livros50a80 = biblioteca.buscarPorPreco(50, 80);
            Assert.assertEquals(2, livros50a80.size());

        } catch (Exception e) {
            Assert.fail("Falha na pesquisa: " + e.getMessage());
        }
    }

    @Test
    public void testaRemocaoELambda() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);

            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarLivro(l2);

            biblioteca.removerLivro("L002");

            boolean existe = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L002"));
            Assert.assertFalse(existe);


            biblioteca.livrosDisponiveis().forEach(l -> System.out.println(l.getTitulo()));

        } catch (Exception e) {
            Assert.fail("Falha na remoção/lambda: " + e.getMessage());
        }
    }

    @Test
    public void testaPersistencia() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);

            biblioteca.cadastrarLivro(l1);

            biblioteca.salvarDados();

            Biblioteca nova = new Biblioteca();
            nova.recuperarDados();

            boolean existe = nova.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L001"));
            Assert.assertTrue(existe);

        } catch (IOException e) {
            Assert.fail("Falha ao salvar/recuperar: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Falha na persistência: " + e.getMessage());
        }
    }
}