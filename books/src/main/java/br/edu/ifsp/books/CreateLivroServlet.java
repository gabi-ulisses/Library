package br.edu.ifsp.books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String titulo = req.getParameter("titulo"); 
		String autor = req.getParameter("autor"); 
		String[] generos = req.getParameterValues("genero"); 
		int anoPublicacao = Integer.parseInt(req.getParameter("anoPublicacao")); 
		ArrayList<String> listaGeneros = new ArrayList<>();
		
		if (generos != null) {
			listaGeneros.addAll(Arrays.asList(generos));
		}

		Livro livro = new Livro(titulo, autor, listaGeneros, anoPublicacao);

		ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista");

		if (listaLivros == null) {
			listaLivros = new ArrayList<>();
		}

		livro.setId(listaLivros.size() + 1); 
		
		listaLivros.add(livro);

		getServletContext().setAttribute("lista", listaLivros);

		resp.sendRedirect("listar-livros");
		
	}
}
