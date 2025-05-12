<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="br.edu.ifsp.books.model.Livro" %>
<%@ include file="header.jsp" %>
<%
    Livro livro = (Livro) request.getAttribute("livro");
    String[] opcoes = {"Ficção", "Não Ficção", "Fantasia", "Romance"};
%>
<section class="bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Editar Livro</h2>
    <form action="editar-livro" method="post">
        <input type="hidden" name="id" value="<%= livro.getId() %>">
        <div class="mb-3">
            <label class="form-label">Título:</label>
            <input type="text" class="form-control" name="titulo" value="<%= livro.getTitulo() %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Autor:</label>
            <input type="text" class="form-control" name="autor" value="<%= livro.getAutor() %>" required>
        </div>
        <fieldset class="mb-3">
            <legend>Gêneros:</legend>
            <%
                for (String genero : opcoes) {
                    boolean marcado = livro.getGeneros().contains(genero);
            %>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="genero" value="<%= genero %>" <%= marcado ? "checked" : "" %> />
                    <label class="form-check-label"><%= genero %></label>
                </div>
            <%
                }
            %>
        </fieldset>
        <div class="mb-3">
            <label class="form-label">Ano de Publicação:</label>
            <input type="number" class="form-control" name="anoPublicacao" value="<%= livro.getAnoPublicacao() %>" required>
        </div>
        <button type="submit" class="btn btn-success">Salvar</button>
        <a href="listar-livros" class="btn btn-outline-secondary">Cancelar</a>
    </form>
</section>
<%@ include file="footer.jsp" %>
