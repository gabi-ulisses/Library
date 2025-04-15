package br.edu.ifsp.books;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/excluir-livro")
public class DeleteLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null && idParam.matches("\\d+")) {
            int id = Integer.parseInt(idParam);

            ArrayList<Livro> livros = (ArrayList<Livro>) getServletContext().getAttribute("lista");

            if (livros != null) {
                livros.removeIf(livro -> livro.getId() == id);
            }
        }

        response.sendRedirect("listar-livros");
    }
}