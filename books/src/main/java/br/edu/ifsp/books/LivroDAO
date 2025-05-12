package br.edu.ifsp.books.dao;

import br.edu.ifsp.books.model.Livro;
import java.util.ArrayList;

public class LivroDAO {

    private static LivroDAO instance;
    private final ArrayList<Livro> listaDeLivros;

    private LivroDAO() {
        this.listaDeLivros = new ArrayList<>();
    }

    public static LivroDAO getInstance() {
        if (instance == null) {
            instance = new LivroDAO();
        }
        return instance;
    }

    // CREATE
    public boolean adicionarLivro(Livro livro) {
        livro.setId(listaDeLivros.size() + 1); // ID incremental simples
        return listaDeLivros.add(livro);
    }

    // READ ALL
    public ArrayList<Livro> getLivros() {
        return new ArrayList<>(listaDeLivros); // evita referência direta
    }

    // READ ONE
    public Livro buscarPorId(int id) {
        for (Livro livro : listaDeLivros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarLivro(Livro livroAtualizado) {
        for (int i = 0; i < listaDeLivros.size(); i++) {
            if (listaDeLivros.get(i).getId() == livroAtualizado.getId()) {
                listaDeLivros.set(i, livroAtualizado);
                return;
            }
        }
    }

    // DELETE
    public boolean removerLivro(int id) {
        return listaDeLivros.removeIf(livro -> livro.getId() == id);
    }
}
