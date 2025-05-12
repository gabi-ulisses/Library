package br.edu.ifsp.books.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.edu.ifsp.books.dao.LivroDAO;
import br.edu.ifsp.books.model.Livro;

@WebServlet("/editar-livro")
public class UpdateLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GET → carrega dados do livro e encaminha para o JSP de edição
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Livro livroSelecionado = LivroDAO.getInstance().buscarPorId(id);

        if (livroSelecionado == null) {
            resp.getWriter().println("Livro não encontrado.");
            return;
        }

        req.setAttribute("livro", livroSelecionado);
        req.getRequestDispatcher("/editar.jsp").forward(req, resp);
    }

    // POST → atualiza o livro com os dados enviados
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String[] generos = req.getParameterValues("genero");
        int ano = Integer.parseInt(req.getParameter("anoPublicacao"));

        ArrayList<String> listaGeneros = new ArrayList<>();
        if (generos != null) {
            listaGeneros.addAll(Arrays.asList(generos));
        }

        Livro livroAtualizado = new Livro(titulo, autor, listaGeneros, ano);
        livroAtualizado.setId(id);

        LivroDAO.getInstance().atualizarLivro(livroAtualizado);

        req.getSession().setAttribute("mensagem", "Livro atualizado com sucesso!");
        resp.sendRedirect("listar-livros");
    }
}
