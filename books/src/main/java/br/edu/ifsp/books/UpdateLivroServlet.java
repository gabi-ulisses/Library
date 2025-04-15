package br.edu.ifsp.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editar-livro")
public class UpdateLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ArrayList<Livro> livros = (ArrayList<Livro>) getServletContext().getAttribute("lista");
        Livro livroSelecionado = null;

        for (Livro l : livros) {
            if (l.getId() == id) {
                livroSelecionado = l;
                break;
            }
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (livroSelecionado == null) {
            out.println("Livro não encontrado.");
            return;
        }

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("  <head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("    <title>Editar Livro</title>");
        out.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css' rel='stylesheet'>");
        out.println("  </head>");
        out.println("  <body class='bg-light'>");

        out.println("    <header class='py-4 bg-secondary-subtle text-dark text-center'>");
        out.println("      <h1>Editar Livro</h1>");
        out.println("    </header>");

        out.println("    <main class='container mt-5'>");
        out.println("      <section class='bg-white p-4 rounded shadow-sm'>");

        out.println("        <form action='editar-livro' method='post'>");
        out.println("          <input type='hidden' name='id' value='" + livroSelecionado.getId() + "'>");

        out.println("          <div class='mb-3'>");
        out.println("            <label class='form-label'>Título:</label>");
        out.println("            <input type='text' class='form-control' name='titulo' value='" + livroSelecionado.getTitulo() + "' required>");
        out.println("          </div>");

        out.println("          <div class='mb-3'>");
        out.println("            <label class='form-label'>Autor:</label>");
        out.println("            <input type='text' class='form-control' name='autor' value='" + livroSelecionado.getAutor() + "' required>");
        out.println("          </div>");

        out.println("          <fieldset class='mb-3'>");
        out.println("            <legend class='col-form-label pt-0'>Gêneros:</legend>");

        String[] opcoes = {"Ficção", "Não Ficção", "Fantasia", "Romance"};
        
        for (String genero : opcoes) {
            boolean marcado = livroSelecionado.getGeneros().contains(genero);
            out.println("            <div class='form-check form-check-inline'>");
            out.println("              <input class='form-check-input' type='checkbox' name='genero' value='" + genero + "'" + (marcado ? " checked" : "") + ">");
            out.println("              <label class='form-check-label'>" + genero + "</label>");
            out.println("            </div>");
        }

        out.println("          </fieldset>");

        out.println("          <div class='mb-4'>");
        out.println("            <label class='form-label'>Ano de Publicação:</label>");
        out.println("            <input type='number' class='form-control' name='anoPublicacao' value='" + livroSelecionado.getAnoPublicacao() + "' required>");
        out.println("          </div>");

        out.println("          <div class='d-flex justify-content-between'>");
        out.println("            <a href='listar-livros' class='btn btn-outline-secondary'>");
        out.println("              <i class='bi bi-arrow-left'></i> Cancelar");
        out.println("            </a>");
        out.println("            <button type='submit' class='btn btn-success'>");
        out.println("              <i class='bi bi-save'></i> Salvar Alterações");
        out.println("            </button>");
        out.println("          </div>");

        out.println("        </form>");
        out.println("      </section>");
        out.println("    </main>");

        out.println("    <footer class='text-center py-4 mt-5 text-muted small'>");
        out.println("      &copy; 2025 — Editando livros com carinho por <strong>Gabrielle Ulisses</strong> 📝");
        out.println("    </footer>");

        out.println("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("  </body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String[] generos = req.getParameterValues("genero");
        int ano = Integer.parseInt(req.getParameter("anoPublicacao"));

        ArrayList<String> listaGeneros = new ArrayList<>();
        if (generos != null) {
            for (String g : generos) {
                listaGeneros.add(g);
            }
        }

        ArrayList<Livro> livros = (ArrayList<Livro>) getServletContext().getAttribute("lista");

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setGeneros(listaGeneros);
                livro.setAnoPublicacao(ano);
                break;
            }
        }

        resp.sendRedirect("listar-livros");
    }
}