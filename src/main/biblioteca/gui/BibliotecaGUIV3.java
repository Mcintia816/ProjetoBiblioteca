package main.biblioteca.gui;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.Usuario;

import javax.swing.*;
import java.awt.*;

public class BibliotecaGUIV3 extends JFrame {

    JLabel titulo, imagem;
    ImageIcon bibliotecaImg = new ImageIcon("./imgs/biblioteca.jpg"); // imagem central
    ImageIcon addImg = new ImageIcon("./imgs/icons/add_book.png");
    ImageIcon userImg = new ImageIcon("./imgs/icons/add_person.png");
    ImageIcon emprestarImg = new ImageIcon("./imgs/icons/borrow.png");
    ImageIcon devolverImg = new ImageIcon("./imgs/icons/return.png");
    ImageIcon salvarImg = new ImageIcon("./imgs/icons/save.png");

    JButton botaoLivro, botaoUsuario, botaoEmprestar, botaoDevolver, botaoSalvar;

    private Biblioteca biblioteca;

    public BibliotecaGUIV3() {
        biblioteca = new Biblioteca();

        setTitle("Sistema de Biblioteca");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        // Título e imagem
        titulo = new JLabel("Bem-vindo à Biblioteca", JLabel.CENTER);
        titulo.setForeground(Color.BLUE);
        titulo.setFont(new Font("Serif", Font.BOLD, 28));
        imagem = new JLabel(bibliotecaImg, JLabel.CENTER);

        // Botões
        botaoLivro = new JButton("Cadastrar Livro", addImg);
        botaoLivro.addActionListener(e -> cadastrarLivro());

        botaoUsuario = new JButton("Cadastrar Usuário", userImg);
        botaoUsuario.addActionListener(e -> cadastrarUsuario());

        botaoEmprestar = new JButton("Emprestar Livro", emprestarImg);
        botaoEmprestar.addActionListener(e -> emprestarLivro());

        botaoDevolver = new JButton("Devolver Livro", devolverImg);
        botaoDevolver.addActionListener(e -> devolverLivro());

        botaoSalvar = new JButton("Salvar Dados", salvarImg);
        botaoSalvar.addActionListener(e -> salvarDados());

        // Layout
        getContentPane().setLayout(new GridLayout(3, 2));
        getContentPane().add(titulo);
        getContentPane().add(botaoLivro);
        getContentPane().add(imagem);
        getContentPane().add(botaoUsuario);
        getContentPane().add(botaoEmprestar);
        getContentPane().add(botaoDevolver);
        // para o salvar, pode colocar em outro painel ou menu depois

    }

    private void cadastrarLivro() {
        String codigo = JOptionPane.showInputDialog(this, "Código do Livro:");
        String titulo = JOptionPane.showInputDialog(this, "Título:");
        String autor = JOptionPane.showInputDialog(this, "Autor:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço:"));

        try {
            biblioteca.cadastrarLivro(new Livro(codigo, titulo, autor, preco, false));
            JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void cadastrarUsuario() {
        String id = JOptionPane.showInputDialog(this, "ID do Usuário:");
        String nome = JOptionPane.showInputDialog(this, "Nome:");

        try {
            biblioteca.cadastrarUsuario(new Usuario(id, nome));
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void emprestarLivro() {
        String codigo = JOptionPane.showInputDialog(this, "Código do Livro:");
        String idUsuario = JOptionPane.showInputDialog(this, "ID do Usuário:");

        biblioteca.emprestarLivro(codigo, idUsuario);
        JOptionPane.showMessageDialog(this, "Empréstimo realizado!");
    }

    private void devolverLivro() {
        String codigo = JOptionPane.showInputDialog(this, "Código do Livro:");
        biblioteca.devolverLivro(codigo);
        JOptionPane.showMessageDialog(this, "Livro devolvido!");
    }

    private void salvarDados() {
        try {
            biblioteca.salvarDados();
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BibliotecaGUIV3 janela = new BibliotecaGUIV3();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}