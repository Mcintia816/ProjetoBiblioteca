package main.biblioteca.controller;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroAddController implements ActionListener {

    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;

    public LivroAddController(Biblioteca biblioteca, JFrame janela) {
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String codigo = JOptionPane.showInputDialog(janelaPrincipal, "Código do Livro:");
            String titulo = JOptionPane.showInputDialog(janelaPrincipal, "Título do Livro:");
            String autor = JOptionPane.showInputDialog(janelaPrincipal, "Autor do Livro:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal, "Preço do Livro:"));

            biblioteca.cadastrarLivro(new Livro(codigo, titulo, autor, preco, false));

            JOptionPane.showMessageDialog(janelaPrincipal, "Livro cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao cadastrar livro: " + ex.getMessage());
        }
    }
}