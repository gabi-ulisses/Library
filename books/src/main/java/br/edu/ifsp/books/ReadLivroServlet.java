package br.edu.ifsp.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("    <title>Lista de Livros</title>");
        out.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");

        // Cabeçalho
        out.println("    <header class='py-4 bg-primary-subtle text-white text-center'>");
        out.println("        <h1 class=\"text-primary-emphasis\">Livros Cadastrados</h1>");
        out.println("    </header>");

        // Conteúdo principal
        out.println("    <main class='container mt-5'>");
        out.println("        <section class='bg-white p-4 rounded shadow-sm'>");

        ArrayList<Livro> livros = (ArrayList<Livro>) getServletContext().getAttribute("lista");

        out.println("            <table class=\"table table-striped-columns table-bordered rounded-3 overflow-hidden\">\n"
        		+ "");
        out.println("                <thead class='table-dark'>");
        out.println("                    <tr>");
        out.println("                        <th>Título</th>");
        out.println("                        <th>Autor</th>");
        out.println("                        <th>Gêneros</th>");
        out.println("                        <th>Ano</th>");
        out.println("                        <th class='text-center'>Ações</th>");
        out.println("                    </tr>");
        out.println("                </thead>");
        out.println("                <tbody>");

        if (livros != null && !livros.isEmpty()) {
            for (Livro livro : livros) {
                out.println("            <tr>");
                out.println("                <td>" + livro.getTitulo() + "</td>");
                out.println("                <td>" + livro.getAutor() + "</td>");
                out.println("                <td>" + String.join(", ", livro.getGeneros()) + "</td>");
                out.println("                <td>" + livro.getAnoPublicacao() + "</td>");
                out.println("                <td class='text-center'>");
                out.println("                  <a href='editar-livro?id=" + livro.getId() + "' class='btn btn-sm btn-outline-secondary me-2' title='Editar'><i class='bi bi-pencil'></i></a>");
                out.println("                  <a href='excluir-livro?id=" + livro.getId() + "' class='btn btn-sm btn-outline-danger' title='Excluir'><i class='bi bi-trash'></i></a>");
                out.println("                </td>");
                out.println("            </tr>");
            }
        } else {
            out.println("                <tr>");
            out.println("                    <td colspan='5' class='text-center'>Nenhum livro cadastrado.</td>");
            out.println("                </tr>");
        }

        out.println("                </tbody>");
        out.println("            </table>");

        // Botão Adicionar
        out.println("            <div class='d-flex justify-content-end mt-4'>");
        out.println("                <a href='index.html' class='btn btn-primary'>");
        out.println("                    <i class='bi bi-plus-lg me-1'></i> Adicionar Novo Livro");
        out.println("                </a>");
        out.println("            </div>");

        out.println("        </section>");
        out.println("    </main>");

        // Rodapé
        out.println("    <footer class='text-center py-4 mt-5 text-muted small'>");
        out.println("        &copy; 2025 — Criado por <strong>Gabrielle Ulisses</strong> para o projeto de CRUD de Livros com Servlets Individuais.");
        out.println("    </footer>");

        out.println("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</body>");
        out.println("</html>");
    }
}