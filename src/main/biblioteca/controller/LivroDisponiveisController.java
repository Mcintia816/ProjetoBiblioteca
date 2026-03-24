package main.biblioteca.controller;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroDisponiveisController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janela;

    public LivroDisponiveisController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var livros = biblioteca.livrosDisponiveis();

        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Nenhum livro disponível.");
            return;
        }

        StringBuilder resultado = new StringBuilder("Disponíveis:\n");
        for (Livro l : livros) {
            resultado.append(l.getCodigo()).append(" - ")
                    .append(l.getTitulo()).append("\n");
        }

        JOptionPane.showMessageDialog(janela, resultado.toString());
    }
}
