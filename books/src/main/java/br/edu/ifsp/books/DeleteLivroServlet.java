package br.edu.ifsp.books.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.books.dao.LivroDAO;

@WebServlet("/excluir-livro")
public class DeleteLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam != null && idParam.matches("\\d+")) {
            int id = Integer.parseInt(idParam);
            LivroDAO.getInstance().removerLivro(id);
        }

        req.getSession().setAttribute("mensagem", "Livro excluído com sucesso!");
        resp.sendRedirect("listar-livros");
    }
}
