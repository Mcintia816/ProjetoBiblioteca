package main.biblioteca.controller;

import main.biblioteca.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroDevolverController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janela;

    public LivroDevolverController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog(janela, "Código do livro:");
        biblioteca.devolverLivro(codigo);
        JOptionPane.showMessageDialog(janela, "Livro devolvido!");
    }
}
