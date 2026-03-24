package test.java;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.Usuario;

public class BibliotecaTest {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        try {
            Livro l1 = new Livro("L001", "Java Básico", "João Silva", 50.0, false);
            Livro l2 = new Livro("L002", "POO Avançado", "Maria Souza", 70.0, false);
            Livro l3 = new Livro("L003", "Estruturas de Dados", "João Silva", 60.0, false);

            biblioteca.cadastrarLivro(l1);
            biblioteca.cadastrarLivro(l2);
            biblioteca.cadastrarLivro(l3);

            Usuario u1 = new Usuario("U001", "Carlos");
            Usuario u2 = new Usuario("U002", "Ana");

            biblioteca.cadastrarUsuario(u1);
            biblioteca.cadastrarUsuario(u2);

            System.out.println("=== Livros disponíveis antes de empréstimos ===");
            biblioteca.livrosDisponiveis().forEach(System.out::println);

            biblioteca.emprestarLivro("L001", "U001");
            biblioteca.emprestarLivro("L003", "U002");

            System.out.println("\nTentando emprestar L001 novamente...");
            biblioteca.emprestarLivro("L001", "U002"); // não fará nada, já está emprestado


            System.out.println("\n=== Livros disponíveis após empréstimos ===");
            biblioteca.livrosDisponiveis().forEach(System.out::println);


            biblioteca.devolverLivro("L001");

            System.out.println("\nTentando devolver L001 novamente...");
            biblioteca.devolverLivro("L001"); // não fará nada, já está disponível


            System.out.println("\n=== Livros disponíveis após devolução ===");
            biblioteca.livrosDisponiveis().forEach(System.out::println);


            biblioteca.salvarDados();
            System.out.println("\nDados salvos com sucesso!");

         //   biblioteca.carregarDados();
          //  System.out.println("Dados carregados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}//