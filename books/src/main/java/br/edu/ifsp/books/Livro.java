package br.edu.ifsp.books;

import java.util.ArrayList;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private ArrayList<String> generos;
    private int anoPublicacao;

    public Livro() {
    }

    public Livro(String titulo, String autor, ArrayList<String> generos, int anoPublicacao) {
        setTitulo(titulo);
        setAutor(autor);
        setGeneros(generos);
        setAnoPublicacao(anoPublicacao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID não pode ser negativo.");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        this.titulo = titulo.trim();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
        this.autor = autor.trim();
    }

    public ArrayList<String> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<String> generos) {
        if (generos == null || generos.isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um gênero deve ser selecionado.");
        }
        this.generos = generos;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao < 1455 || anoPublicacao > 2025) {
            throw new IllegalArgumentException("Ano de publicação deve estar entre 1500 e 2025.");
        }
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Autor: " + autor +
                ", Gêneros: " + String.join(", ", generos) +
                ", Ano: " + anoPublicacao;
    }
}
