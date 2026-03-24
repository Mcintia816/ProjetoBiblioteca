package main.biblioteca.controller;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroPesquisarAutorController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janela;

    public LivroPesquisarAutorController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String autor = JOptionPane.showInputDialog(janela, "Autor:");
            var livros = biblioteca.pesquisarLivrosDoAutor(autor);

            StringBuilder resultado = new StringBuilder("Livros:\n");
            for (Livro l : livros) {
                resultado.append(l.getCodigo()).append(" - ")
                        .append(l.getTitulo()).append("\n");
            }

            JOptionPane.showMessageDialog(janela, resultado.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(janela, ex.getMessage());
        }
    }
}
