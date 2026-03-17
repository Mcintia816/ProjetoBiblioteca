package main.biblioteca;

import java.io.IOException;
import java.util.List;

public interface BibliotecaGerenciador {
    public void cadastrarLivro(Livro livro) throws LivroJaExisteException ;
    public void removerLivro(String codigo);
    public List<Livro> pesquisarLivrosDoAutor(String nomeAutor) throws LivroNaoExisteException;
    public List<Livro> livrosDisponiveis();
    public Livro livroMaisBarato();
    public void devolverLivro(String codLivro);
    public void emprestarLivro(String codLivro, String idUsuario);
    public List<Livro> buscarPorPreco(double min, double max);
    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException;
    public void salvarDados() throws IOException;
    //public void carregarDados() throws IOException, ClassCastException;
}
//