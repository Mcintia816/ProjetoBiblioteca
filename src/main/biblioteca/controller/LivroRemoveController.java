package main.biblioteca.controller;

import main.biblioteca.Biblioteca;
import main.biblioteca.LivroNaoExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroRemoveController implements ActionListener {

    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;

    public LivroRemoveController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do livro a remover?");
        try {
            biblioteca.removerLivro(codigo);
            JOptionPane.showMessageDialog(janelaPrincipal, "Livro removido com sucesso!");
        } catch (LivroNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Livro não encontrado. Operação não realizada.");
        }
    }
}