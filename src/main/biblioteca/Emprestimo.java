package main.biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprestimo implements Serializable {
    private String codigo;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    public Emprestimo(String codigo, Livro livro, Usuario usuario,LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.codigo = codigo;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public Emprestimo(String codLivro, Livro livro, Usuario usuario) {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
