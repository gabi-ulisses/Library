<%@ include file="header.jsp" %>
<section class="bg-white p-4 rounded shadow-sm" aria-labelledby="form-title">
    <h2 id="form-title" class="mb-4 text-center">Preencha os dados do livro</h2>
    <form action="criar-livro" method="POST">
        <div class="mb-3">
            <label for="titulo" class="form-label">Título do livro:</label>
            <input type="text" id="titulo" name="titulo" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="autor" class="form-label">Autor:</label>
            <input type="text" id="autor" name="autor" class="form-control" required>
        </div>
        <fieldset class="mb-3">
            <legend class="col-form-label pt-0">Gênero:</legend>
            <div class="form-check form-check-inline">
                <input type="checkbox" id="ficcao" name="genero" value="Ficção" class="form-check-input">
                <label for="ficcao" class="form-check-label">Ficção</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="checkbox" id="nao-ficcao" name="genero" value="Não Ficção" class="form-check-input">
                <label for="nao-ficcao" class="form-check-label">Não Ficção</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="checkbox" id="fantasia" name="genero" value="Fantasia" class="form-check-input">
                <label for="fantasia" class="form-check-label">Fantasia</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="checkbox" id="romance" name="genero" value="Romance" class="form-check-input">
                <label for="romance" class="form-check-label">Romance</label>
            </div>
        </fieldset>
        <div class="mb-4">
            <label for="ano-publicacao" class="form-label">Ano de publicação:</label>
            <input type="number" id="ano-publicacao" name="anoPublicacao" class="form-control" min="1455" max="2025" required>
        </div>
        <div class="d-flex justify-content-between">
            <a href="listar-livros" class="btn btn-outline-secondary" title="Visualizar livros cadastrados">
                <i class="bi bi-journal-bookmark fs-5"></i>
                <span class="visually-hidden">Visualizar livros cadastrados</span>
            </a>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </div>
    </form>
</section>
<%@ include file="footer.jsp" %>
