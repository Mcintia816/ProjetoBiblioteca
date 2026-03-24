package test;

import main.biblioteca.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BibliotecaTest {

    @Test
    public void testaBibliotecaCompleta() {
        try {
            Biblioteca biblioteca = new Biblioteca();


            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);
            Livro l3 = new Livro("L003", "Estruturas de Dados", "João Silva", 40.0, false);

            Usuario u1 = new Usuario("U001", "Carlos");
            Usuario u2 = new Usuario("U002", "Ana");


            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarLivro(l2);
            biblioteca.cadastrarLivro(l3);


            try {
                biblioteca.cadastrarLivro(l1);
                Assert.fail("Deveria lançar LivroJaExisteException");
            } catch (LivroJaExisteException ignored) {}


            biblioteca.cadastrarUsuario(u1);
            biblioteca.cadastrarUsuario(u2);


            try {
                biblioteca.cadastrarUsuario(u1);
                Assert.fail("Deveria lançar UsuarioJaExisteException");
            } catch (UsuarioJaExisteException ignored) {}


            biblioteca.emprestarLivro("L001", "U001");


            boolean encontrado = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L001"));
            Assert.assertFalse(encontrado);


            biblioteca.emprestarLivro("L001", "U002");
            long quantidade = biblioteca.livrosDisponiveis()
                    .stream()
                    .filter(l -> l.getCodigo().equals("L001"))
                    .count();
            Assert.assertEquals(0, quantidade);


            biblioteca.devolverLivro("L001");

            boolean voltou = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L001"));
            Assert.assertTrue(voltou);


            biblioteca.devolverLivro("L001");


            List<Livro> livrosDoJoao = biblioteca.pesquisarLivrosDoAutor("João Silva");
            Assert.assertEquals(2, livrosDoJoao.size());


            try {
                biblioteca.pesquisarLivrosDoAutor("Autor Inexistente");
                Assert.fail("Deveria lançar LivroNaoExisteException");
            } catch (LivroNaoExisteException ignored) {}


            Livro maisBarato = biblioteca.livroMaisBarato();
            Assert.assertEquals("L003", maisBarato.getCodigo());


            List<Livro> livrosEntre50e80 = biblioteca.buscarPorPreco(50, 80);
            Assert.assertEquals(2, livrosEntre50e80.size());


            biblioteca.removerLivro("L002");
            boolean removido = biblioteca.livrosDisponiveis()
                    .stream()
                    .anyMatch(l -> l.getCodigo().equals("L002"));
            Assert.assertFalse(removido);


            try {
                biblioteca.salvarDados();
            } catch (IOException e) {
                Assert.fail("Não deveria lançar IOException ao salvar");
            }

        } catch (Exception e) {
            Assert.fail("Teste falhou com exceção: " + e.getMessage());
        }
    }
}
