package main.biblioteca;

import java.io.Serializable;

public class Livro implements Serializable {
    private String codigo;
    private String titulo;
    private String autor;
    private double preco;
    private boolean emprestado;

    public Livro(String codigo, String titulo, String autor, double preco, boolean emprestado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.emprestado = emprestado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", emprestado=" + emprestado +
                '}';
    }
}


