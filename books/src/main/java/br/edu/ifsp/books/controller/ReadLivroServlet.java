package br.edu.ifsp.books.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.books.dao.LivroDAO;
import br.edu.ifsp.books.model.Livro;

@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtem lista de livros do DAO
        ArrayList<Livro> livros = LivroDAO.getInstance().getLivros();

        // Adiciona a lista como atributo da requisição
        request.setAttribute("livros", livros);

        // Encaminha para o JSP que exibirá os dados
        request.getRequestDispatcher("/lista.jsp").forward(request, response);
    }
}
