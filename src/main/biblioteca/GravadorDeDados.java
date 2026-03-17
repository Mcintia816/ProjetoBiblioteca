package main.biblioteca;import java.io.*;
import java.util.*;

    public class GravadorDeDados {

        private static final String ARQUIVO = "biblioteca.dat";

        public void gravarDados(Map<String, Livro> livros,
                                Map<String, Usuario> usuarios,
                                List<Emprestimo> emprestimos) throws IOException {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO));

            oos.writeObject(livros);
            oos.writeObject(usuarios);
            oos.writeObject(emprestimos);

            oos.close();
        }

        public Object[] recuperarDados() throws IOException, ClassNotFoundException {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO));

            Map<String, Livro> livros = (Map<String, Livro>) ois.readObject();
            Map<String, Usuario> usuarios = (Map<String, Usuario>) ois.readObject();
            List<Emprestimo> emprestimos = (List<Emprestimo>) ois.readObject();

            ois.close();

            return new Object[]{livros, usuarios, emprestimos};
        }
    }

//