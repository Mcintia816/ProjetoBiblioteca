package main.biblioteca.gui;

import main.biblioteca.Biblioteca;
import main.biblioteca.Livro;
import main.biblioteca.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BibliotecaGUIV3ComMenu extends JFrame {

    JLabel titulo, imagem;
    ImageIcon bibliotecaImg = new ImageIcon("./imgs/biblioteca.png");
    Biblioteca biblioteca = new Biblioteca();
    JMenuBar barraDeMenu = new JMenuBar();

    public BibliotecaGUIV3ComMenu() {
        setTitle("Sistema de Biblioteca");
        setSize(900, 700);
        setLocation(300, 200);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setLayout(new BorderLayout());

        titulo = new JLabel("Bem-vindo à Biblioteca", JLabel.CENTER);
        titulo.setForeground(Color.BLUE);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 600));


        imagem = new JLabel(bibliotecaImg);
        imagem.setBounds(0, 0, 900, 600); // tamanho da imagem
        layeredPane.add(imagem, Integer.valueOf(0));

        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        JButton btnEmprestar = new JButton("Emprestar Livro");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnRemover = new JButton("Remover Livro");
        JButton btnPesquisarAutor = new JButton("Pesquisar por Autor");
        JButton btnDisponiveis = new JButton("Livros Disponíveis");
        JButton btnSalvarDados = new JButton("Salvar Dados");

        btnCadastrarLivro.setBounds(50, 450, 160, 40);
        btnCadastrarUsuario.setBounds(230, 450, 160, 40);
        btnEmprestar.setBounds(410, 450, 140, 40);
        btnDevolver.setBounds(570, 450, 140, 40);
        btnRemover.setBounds(730, 450, 140, 40);

        btnPesquisarAutor.setBounds(180, 510, 160, 40);
        btnDisponiveis.setBounds(360, 510, 160, 40);
        btnSalvarDados.setBounds(540, 510, 160, 40);


        layeredPane.add(btnCadastrarLivro, Integer.valueOf(1));
        layeredPane.add(btnCadastrarUsuario, Integer.valueOf(1));
        layeredPane.add(btnEmprestar, Integer.valueOf(1));
        layeredPane.add(btnDevolver, Integer.valueOf(1));
        layeredPane.add(btnRemover, Integer.valueOf(1));
        layeredPane.add(btnPesquisarAutor, Integer.valueOf(1));
        layeredPane.add(btnDisponiveis, Integer.valueOf(1));
        layeredPane.add(btnSalvarDados, Integer.valueOf(1));

        add(layeredPane, BorderLayout.CENTER);

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarLivro = new JMenuItem("Cadastrar Livro");
        JMenuItem menuCadastrarUsuario = new JMenuItem("Cadastrar Usuário");
        menuCadastrar.add(menuCadastrarLivro);
        menuCadastrar.add(menuCadastrarUsuario);

        JMenu menuOperacoes = new JMenu("Operações");
        JMenuItem menuEmprestar = new JMenuItem("Emprestar Livro");
        JMenuItem menuDevolver = new JMenuItem("Devolver Livro");
        JMenuItem menuRemover = new JMenuItem("Remover Livro");
        menuOperacoes.add(menuEmprestar);
        menuOperacoes.add(menuDevolver);
        menuOperacoes.add(menuRemover);

        JMenu menuConsultas = new JMenu("Consultas");
        JMenuItem menuPesquisarAutor = new JMenuItem("Pesquisar por Autor");
        JMenuItem menuDisponiveis = new JMenuItem("Livros Disponíveis");
        menuConsultas.add(menuPesquisarAutor);
        menuConsultas.add(menuDisponiveis);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Salvar Dados");
        menuSalvar.add(menuSalvarDados);

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuOperacoes);
        barraDeMenu.add(menuConsultas);
        barraDeMenu.add(menuSalvar);

        setJMenuBar(barraDeMenu);


        menuCadastrarLivro.addActionListener(ae -> cadastrarLivro());
        menuCadastrarUsuario.addActionListener(ae -> cadastrarUsuario());
        menuEmprestar.addActionListener(ae -> emprestarLivro());
        menuDevolver.addActionListener(ae -> devolverLivro());
        menuRemover.addActionListener(ae -> removerLivro());
        menuPesquisarAutor.addActionListener(ae -> pesquisarPorAutor());
        menuDisponiveis.addActionListener(ae -> listarDisponiveis());
        menuSalvarDados.addActionListener(ae -> salvarDados());


        btnCadastrarLivro.addActionListener(ae -> cadastrarLivro());
        btnCadastrarUsuario.addActionListener(ae -> cadastrarUsuario());
        btnEmprestar.addActionListener(ae -> emprestarLivro());
        btnDevolver.addActionListener(ae -> devolverLivro());
        btnRemover.addActionListener(ae -> removerLivro());
        btnPesquisarAutor.addActionListener(ae -> pesquisarPorAutor());
        btnDisponiveis.addActionListener(ae -> listarDisponiveis());
        btnSalvarDados.addActionListener(ae -> salvarDados());
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

    private void removerLivro() {
        String codigo = JOptionPane.showInputDialog(this, "Código do livro:");
        biblioteca.removerLivro(codigo);
        JOptionPane.showMessageDialog(this, "Livro removido!");
    }

    private void pesquisarPorAutor() {
        String autor = JOptionPane.showInputDialog(this, "Nome do autor:");

        try {
            List<Livro> livros = biblioteca.pesquisarLivrosDoAutor(autor);

            StringBuilder resultado = new StringBuilder("Livros encontrados:\n");
            for (Livro l : livros) {
                resultado.append(l.getCodigo()).append(" - ")
                        .append(l.getTitulo()).append("\n");
            }

            JOptionPane.showMessageDialog(this, resultado.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void listarDisponiveis() {
        List<Livro> livros = biblioteca.livrosDisponiveis();

        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum livro disponível.");
            return;
        }

        StringBuilder resultado = new StringBuilder("Livros disponíveis:\n");
        for (Livro l : livros) {
            resultado.append(l.getCodigo()).append(" - ")
                    .append(l.getTitulo()).append("\n");
        }

        JOptionPane.showMessageDialog(this, resultado.toString());
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
        BibliotecaGUIV3ComMenu janela = new BibliotecaGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}