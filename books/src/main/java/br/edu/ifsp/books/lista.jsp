<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="br.edu.ifsp.books.model.Livro" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="header.jsp" %>
<%
    String mensagem = (String) session.getAttribute("mensagem");
    if (mensagem != null) {
%>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <%= mensagem %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar"></button>
    </div>
<%
        session.removeAttribute("mensagem"); // Apaga para não aparecer de novo
    }
%>

<section class="bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Livros Cadastrados</h2>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Gêneros</th>
                <th>Ano</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Livro> livros = (ArrayList<Livro>) request.getAttribute("livros");
            if (livros != null && !livros.isEmpty()) {
                for (Livro livro : livros) {
        %>
            <tr>
                <td><%= livro.getTitulo() %></td>
                <td><%= livro.getAutor() %></td>
                <td><%= String.join(", ", livro.getGeneros()) %></td>
                <td><%= livro.getAnoPublicacao() %></td>
                <td>
                    <a href="editar-livro?id=<%= livro.getId() %>" class="btn btn-sm btn-secondary">Editar</a>
                    <a href="excluir-livro?id=<%= livro.getId() %>" class="btn btn-sm btn-danger">Excluir</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="5" class="text-center">Nenhum livro cadastrado.</td></tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-primary">Adicionar Novo Livro</a>
</section>

<%@ include file="footer.jsp" %>
