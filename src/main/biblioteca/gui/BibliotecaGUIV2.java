package main.biblioteca.gui;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.Usuario;

import javax.swing.*;
import java.awt.*;

public class BibliotecaGUIV2 extends JFrame {

    JLabel titulo, imagem;
    ImageIcon bibliotecaImg = new ImageIcon("./imgs/biblioteca.jpg");// mgs
    private Biblioteca biblioteca;

    public BibliotecaGUIV2() {
        biblioteca = new Biblioteca(); 

        setTitle("Sistema de Biblioteca");
        setSize(500, 500);
        setLocation(0, 0);
        setResizable(true);
        getContentPane().setBackground(Color.white);

        
        titulo = new JLabel("Bem-vindo à Biblioteca", JLabel.CENTER);
        titulo.setForeground(Color.BLUE);
        titulo.setFont(new Font("Serif", Font.BOLD, 28));

        
        imagem = new JLabel(bibliotecaImg, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(titulo);
        getContentPane().add(imagem);

        
        criarMenu();
    }

    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");

        JMenuItem cadastrarLivro = new JMenuItem("Cadastrar Livro");
        cadastrarLivro.addActionListener(e -> cadastrarLivro());

        JMenuItem cadastrarUsuario = new JMenuItem("Cadastrar Usuário");
        cadastrarUsuario.addActionListener(e -> cadastrarUsuario());

        JMenuItem emprestarLivro = new JMenuItem("Emprestar Livro");
        emprestarLivro.addActionListener(e -> emprestarLivro());

        JMenuItem devolverLivro = new JMenuItem("Devolver Livro");
        devolverLivro.addActionListener(e -> devolverLivro());

        JMenuItem salvarDados = new JMenuItem("Salvar Dados");
        salvarDados.addActionListener(e -> salvarDados());

        menu.add(cadastrarLivro);
        menu.add(cadastrarUsuario);
        menu.add(emprestarLivro);
        menu.add(devolverLivro);
        menu.add(salvarDados);

        menuBar.add(menu);
        setJMenuBar(menuBar);
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
        BibliotecaGUIV2 janela = new BibliotecaGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
