package main.biblioteca.controller;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.LivroNaoExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LivroSearchController implements ActionListener {

    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;

    public LivroSearchController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String autor = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do autor:");

        try {
            List<Livro> livros = biblioteca.pesquisarLivrosDoAutor(autor);

            if (!livros.isEmpty()) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Livros encontrados:");
                for (Livro l : livros) {
                    JOptionPane.showMessageDialog(janelaPrincipal, l.toString());
                }
            }

        } catch (LivroNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Nenhum livro encontrado para esse autor.");
        }
    }
}