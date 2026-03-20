package main.biblioteca;

import java.io.IOException;
import java.util.*;

public class Biblioteca implements BibliotecaGerenciador {

    private Map<String,Livro> livros = new HashMap<>();
    private Map<String, Usuario> usuarios = new HashMap<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private GravadorDeDados gravador = new GravadorDeDados();



    @Override
    public void cadastrarLivro(Livro livro) throws LivroJaExisteException {
        if(this.livros.containsKey(livro.getCodigo())) {
            throw new LivroJaExisteException("Já existe livro com esse código");
        }
        livros.put(livro.getCodigo(),livro);

    }


    @Override
    public void removerLivro(String codigo) {
        livros.remove(codigo);

    }

    @Override
    public List<Livro> pesquisarLivrosDoAutor(String nomeAutor) throws LivroNaoExisteException {
        List<Livro> livroA = new ArrayList<>();
        for(Livro l: this.livros.values()){
            if(l.getAutor().equals(nomeAutor)){
                livroA.add(l);
            }

        }
        if(livroA.isEmpty()){
            throw new LivroNaoExisteException("Nenhum livro encontrado para esse autor");
        }
        return livroA;
    }

    @Override
    public List<Livro> livrosDisponiveis() {
       return livros.values().stream().filter(l->!l.isEmprestado()).toList();
    }

    @Override
    public Livro livroMaisBarato() {
       return livros.values().stream().min(Comparator.comparing(Livro::getPreco)).orElse(null);
    }

    @Override
    public void devolverLivro(String codLivro) {
           Livro livro = livros.get(codLivro);
           if(livro!=null){
               livro.setEmprestado(false);
           }
    }

    @Override
    public void emprestarLivro(String codLivro, String idUsuario) {
         Livro livro = livros.get(codLivro);
         Usuario usuario = usuarios.get(idUsuario);

         if(livro != null && !livro.isEmprestado()){
             livro.setEmprestado(true);
             emprestimos.add(new Emprestimo(codLivro,livro,usuario));
         }
    }

    @Override
    public List<Livro> buscarPorPreco(double min, double max) {
        return livros.values().stream().filter(l->l.getPreco()>=min && l.getPreco()<=max).toList();
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException {
        if (usuarios.containsKey(usuario.getId())) {
            throw new UsuarioJaExisteException("Usuario já cadastrado");

        }
        usuarios.put(usuario.getId(),usuario);
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.gravarDados(livros, usuarios, emprestimos);
    }


    public void recuperarDados() {
        try {
            Object[] dados = gravador.recuperarDados();
            this.livros = (Map<String, Livro>) dados[0];
            this.usuarios = (Map<String, Usuario>) dados[1];
            this.emprestimos = (List<Emprestimo>) dados[2];
        } catch (Exception e) {
            System.err.println("Falha ao recuperar dados: " + e.getMessage());
        }
    }
}
//